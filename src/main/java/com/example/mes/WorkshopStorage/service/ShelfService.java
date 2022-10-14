package com.example.mes.WorkshopStorage.service;

import com.example.mes.WorkshopStorage.mapper.GoodsMapper;
import com.example.mes.WorkshopStorage.mapper.GoodsMessageMapper;
import com.example.mes.WorkshopStorage.mapper.ShelfMapper;
import com.example.mes.WorkshopStorage.para.GoodsUpdatePara;
import com.example.mes.WorkshopStorage.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ShelfService {
    @Autowired
    private ShelfMapper shelfMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsMessageMapper goodsMessageMapper;
    public Result<PageVo<ShelfVo>> shelfItemById(String storage_id, String page, String page_size, String company_id) throws SQLException {
        Result<PageVo<ShelfVo>> result = new Result<>();
        PageVo<ShelfVo> pageVo = new PageVo();
        Integer size = shelfMapper.getCountById(storage_id,company_id);
        if(size == null)
            size = 0;
        pageVo.setTotal(size);
        pageVo.setSize((size - 1) / Integer.parseInt(page_size) + 1);
        if (pageVo.getSize() < 0) {
            pageVo.setSize(0);
        }
        if (Integer.parseInt(page) > pageVo.getSize()) {
            throw new SQLException();
        }
        if (Integer.parseInt(page) == pageVo.getSize()) {
            pageVo.setPages((size - 1) % Integer.parseInt(page_size) + 1);
        } else {
            pageVo.setPages(Integer.parseInt(page_size));
        }
        pageVo.setCurrent(Integer.parseInt(page));
        List<ShelfVo> currentlist = shelfMapper.selectAllById(storage_id, (pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        for(ShelfVo shelfVo : currentlist){
            Integer cnt;
            cnt = goodsMapper.getGoodsNumById(storage_id, shelfVo.getId(),company_id);
            if(cnt != null){
                shelfVo.setQuantity(cnt);
            }
        }
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public Result<List<ShelfVo>> search(String storage_id, String id, String company_id){
        Result<List<ShelfVo>> shelfVoResult = new Result<>();
        ShelfVo shelfVo = shelfMapper.getById(storage_id, id,company_id);
        Integer cnt = goodsMapper.getGoodsNumById(storage_id, id,company_id);
        if(cnt == null){
            cnt = 0;
        }
        shelfVo.setQuantity(cnt);
        List<ShelfVo> shelfVoList = new LinkedList<>();
        shelfVoList.add(shelfVo);
        shelfVoResult.setResult(shelfVoList);
        return shelfVoResult;
    }

    public List<ShelfVo> shelfById(String storage_id, String company_id){
        return shelfMapper.shelfById(storage_id,company_id);
    }

    public void move(GoodsUpdatePara params, String company_id) throws SQLException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<GoodsVo> goodsVoList = goodsMapper.getByShelfId(params.getStorage_id(), params.getShelf_id(),company_id);
        if(goodsVoList == null)return;
        ShelfVo shelfVo = shelfMapper.getById(params.getNewStorage_id(), params.getNewShelf_id(),company_id);
        if(shelfVo == null){
            throw new SQLException();
        }
        List<GoodsVo> goodsVoList1 = goodsMapper.getApplyByShelf(params.getStorage_id(), params.getShelf_id(),company_id);
        if(goodsVoList1 != null && goodsVoList1.size()!=0){
            throw new SQLException();
        }
        for(GoodsVo goodsVo : goodsVoList){
            GoodsVo goodsVo1 = goodsMapper.getById(params.getNewStorage_id(), params.getNewShelf_id(), goodsVo.getId(),company_id);
            if(goodsVo1 != null){
                if(!goodsVo1.getGoods_id().equals(goodsVo.getGoods_id()) || !goodsVo1.getTypes().equals(goodsVo.getTypes())){
                    throw new SQLException();
                }
            }
        }
        for(GoodsVo goodsVo : goodsVoList){
            goodsMapper.delete(goodsVo.getStorage_id(), goodsVo.getShelf_id(), goodsVo.getId(), timestamp,company_id);
            goodsVo.setStorage_id(params.getNewStorage_id());
            goodsVo.setShelf_id(params.getNewShelf_id());
            goodsVo.setId(goodsVo.getId());
            GoodsVo goodsVo1 = goodsMapper.getById(params.getNewStorage_id(), params.getNewShelf_id(), goodsVo.getId(),company_id);
            goodsVo.setCompany_id(company_id);
            if(goodsVo1 != null){
                goodsMapper.updateQuantity(params.getNewShelf_id(), params.getNewShelf_id(), goodsVo.getId(), goodsVo1.getQuantity() + goodsVo.getQuantity(), timestamp,company_id);
            }else{
                goodsMapper.insert(goodsVo);
            }
            List<GoodsMessageVo> goodsMessageVoList = goodsMessageMapper.getByShelf(params.getStorage_id(), params.getShelf_id(),company_id);
            for(GoodsMessageVo goodsMessageVo : goodsMessageVoList){
                goodsMessageVo.setCreated_time(timestamp);
                goodsMessageVo.setStorage_id(params.getNewStorage_id());
                goodsMessageVo.setShelf_id(params.getNewShelf_id());
                goodsMessageVo.setLocation(goodsVo.getId());
                goodsMessageVo.setCompany_id(company_id);
                goodsMessageMapper.delete(goodsMessageVo.getUuid(), timestamp,company_id);
                goodsMessageMapper.insert(goodsMessageVo);
            }

        }
    }
    public void insert(String storage_id, String id, String user, String company_id) throws SQLException {
        if(shelfMapper.getById(storage_id, id,company_id) != null){
            throw new SQLException();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());;
        ShelfVo shelfVo = new ShelfVo();
        shelfVo.setUuid(UUID.randomUUID().toString().replace("-", ""));
        shelfVo.setStorage_id(storage_id);
        shelfVo.setId(id);
        shelfVo.setTypes("material");
        shelfVo.setStatus("1");
        shelfVo.setIs_deleted("0");
        shelfVo.setCreated_time(timestamp);
        shelfVo.setCreated_by(user);
        shelfVo.setModified_by(user);
        shelfVo.setModified_time(timestamp);
        shelfVo.setCompany_id(company_id);
        shelfMapper.insert(shelfVo);
    }

    public void delete(String storage_id, String id, String user, String company_id) throws SQLException{
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());;
        List<GoodsVo> goodsVoList = goodsMapper.getByShelfId(storage_id, id,company_id);
        if(!(goodsVoList == null || goodsVoList.size() == 0)){
            throw new SQLException();
        }
        if(shelfMapper.getById(storage_id, id,company_id) == null){
            throw new SQLException();
        }
        shelfMapper.delete(storage_id,id,user,timestamp,company_id);
    }
}
