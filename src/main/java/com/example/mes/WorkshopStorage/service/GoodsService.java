package com.example.mes.WorkshopStorage.service;

import com.example.mes.WorkshopStorage.mapper.*;
import com.example.mes.WorkshopStorage.para.GoodsUpdatePara;
import com.example.mes.WorkshopStorage.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsMessageMapper goodsMessageMapper;
    @Autowired
    private ShelfMapper shelfMapper;
    @Autowired
    private WorkshopMapper workshopMapper;
    @Autowired
    private StorageMapper storageMapper;
    public void setTime(ApplyVo workshop, String user, String company_id) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        workshop.setUuid(uuid);
        workshop.setStatus("0");
        workshop.setIs_deleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        workshop.setCreated_by(user);
        workshop.setModified_by(user);
        workshop.setCreated_time(timestamp);
        workshop.setModified_time(timestamp);
        workshop.setCompany_id(company_id);
    }
    public void setTime(GoodsVo workshop, String user, String company_id) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        workshop.setUuid(uuid);
        workshop.setStatus("0");
        workshop.setIs_deleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        workshop.setCreated_by(user);
        workshop.setModified_by(user);
        workshop.setCreated_time(timestamp);
        workshop.setModified_time(timestamp);
        workshop.setCompany_id(company_id);
    }

    public void setTime(GoodsMessageVo workshop, String user, String company_id) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        workshop.setUuid(uuid);
        workshop.setStatus("0");
        workshop.setIs_deleted("0");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        workshop.setCreated_by(user);
        workshop.setModified_by(user);
        workshop.setCreated_time(timestamp);
        workshop.setModified_time(timestamp);
        workshop.setCompany_id(company_id);
    }

    private Timestamp getTime(){
        return new Timestamp(System.currentTimeMillis());
    }
    public Result<List<GoodsVo>> search(String storage_id, String id, String company_id){
        Result<List<GoodsVo>> result = new Result<>();
        List<GoodsVo> goodsVoList = goodsMapper.getByShelfId(storage_id, id,company_id);
        result.setResult(goodsVoList);
        return result;
    }

    public void move(GoodsUpdatePara params,String company_id) throws SQLException {

        Timestamp timestamp = getTime();
        GoodsVo goodsVo = goodsMapper.getById(params.getStorage_id(), params.getShelf_id(), params.getLocation(),company_id);
        GoodsVo goodsVo1 = goodsMapper.getById(params.getNewStorage_id(), params.getNewShelf_id(), params.getNewLocation(),company_id);
        if(goodsVo1 != null) {
            if(!goodsVo1.getGoods_id().equals(goodsVo.getGoods_id()) || !goodsVo1.getTypes().equals(goodsVo.getTypes())){
                throw new SQLException();
            }
        }
        if(goodsVo1 != null){
            goodsMapper.updateQuantity(goodsVo1.getStorage_id(), goodsVo1.getShelf_id(), goodsVo1.getId(), goodsVo1.getQuantity() + goodsVo.getQuantity(), timestamp,company_id);
        }else{
            goodsVo.setStorage_id(params.getNewStorage_id());
            goodsVo.setShelf_id(params.getNewShelf_id());
            goodsVo.setId(params.getNewLocation());
            goodsVo.setModified_time(timestamp);
            goodsVo.setCreated_time(timestamp);
            goodsVo.setCompany_id(company_id);
            goodsMapper.insert(goodsVo);
        }
        goodsMapper.delete(params.getStorage_id(), params.getShelf_id(), params.getLocation(), timestamp,company_id);
        List<GoodsMessageVo> goodsMessageVoList = goodsMessageMapper.getById(params.getStorage_id(), params.getShelf_id(), params.getLocation(),company_id);

        for(GoodsMessageVo goodsMessageVo : goodsMessageVoList){
            goodsMessageVo.setCreated_time(timestamp);
            goodsMessageVo.setModified_time(timestamp);
            goodsMessageVo.setStorage_id(goodsVo.getStorage_id());
            goodsMessageVo.setShelf_id(goodsVo.getShelf_id());
            goodsMessageVo.setLocation(goodsVo.getId());
            goodsMessageVo.setCompany_id(company_id);
            goodsMessageMapper.delete(goodsMessageVo.getUuid(), timestamp,company_id);
            goodsMessageMapper.insert(goodsMessageVo);
        }
    }

    public void apply(String workshop_id, String id, int quantity, String type, String user, String in_out, String storage_id, String shelf_id, String company_id) throws SQLException {
        if(workshopMapper.getById(workshop_id,company_id) == null){
            throw new SQLException();
        }
        String name;
        if(type.equals("material")){
            name = goodsMapper.getMaterial(id,company_id);
            if(name == null){
                throw new SQLException();
            }
        }else{
            name = goodsMapper.getEquipment(id,company_id);
            if(name == null){
                throw new SQLException();
            }
        }
        ApplyVo applyVo = new ApplyVo();
        setTime(applyVo, user,company_id);
        applyVo.setGoods_name(name);
        applyVo.setWorkshop_id(workshop_id);
        applyVo.setGoods_id(id);
        applyVo.setPermit("0");
        applyVo.setQuantity(quantity);
        applyVo.setTypes(type);
        applyVo.setIn_out(in_out);
        applyVo.setStorage_id(storage_id);
        applyVo.setShelf_id(shelf_id);
        applyVo.setCompany_id(company_id);
        goodsMapper.addApply(applyVo);
    }

    public Result<PageVo<ApplyVo>> applyItem(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<ApplyVo>> result = new Result<>();
        PageVo<ApplyVo> pageVo = new PageVo();
        Integer size = goodsMapper.getApplyCount(company_id);
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
        List<ApplyVo> currentlist = goodsMapper.selectAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public Result<PageVo<ApplyVo>> searchApply(String page, String page_size, String goods_id, String goods_name, Date time1, Date time2, String type,String company_id) throws SQLException {
        Result<PageVo<ApplyVo>> result = new Result<>();
        PageVo<ApplyVo> pageVo = new PageVo();
        Integer size = goodsMapper.getApplyCount_search(goods_id, goods_name, time1, time2, type,company_id);
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
        List<ApplyVo> currentlist = goodsMapper.selectAll_search((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(), goods_id, goods_name, time1, time2, type,company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public Result<Integer> searchQuantity(String goods_id, String types,String company_id){
        Result<Integer> result = new Result<>();
        Integer count = goodsMapper.searchQuantity(goods_id, types,company_id);
        if(count == null)
            count = 0;
        result.setResult(count);
        return result;
    }

    public void setApply(String workshop_id, String user, String company_id){
        goodsMapper.setApply(workshop_id, user, getTime(),company_id);
    }

    public Result<PageVo<ApplyVo>> setApplyItem(String page, String page_size,String company_id) throws SQLException{
        Result<PageVo<ApplyVo>> result = new Result<>();
        PageVo<ApplyVo> pageVo = new PageVo();
        Integer size = goodsMapper.getsetApplyCount(company_id);
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
        List<ApplyVo> currentlist = goodsMapper.selectsetAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public void managerConfirm(String uuid, String message, String in_out,String company_id){
        String uuid1 = UUID.randomUUID().toString().replace("-", "");
        if(message.equals("1")){
            if(in_out.equals("入库")){
                int Min=0;
                int Max=100;
                String random = String.valueOf(Min + (int)(Math.random() * ((Max - Min) + 1)));
                goodsMapper.managerConfirm_in(uuid,uuid1,random,company_id);
            }
            else{

                int quantity = goodsMapper.search_quantity(uuid,company_id);
                System.out.println(quantity);
                List<GoodsVo> currentlist = goodsMapper.search_out(uuid,company_id);
                for (int i = 0; i < currentlist.size(); i++) {
                    GoodsVo element = currentlist.get(i);
                    if (element.getQuantity() <= quantity) {
                        quantity -= element.getQuantity();
                        System.out.println(element.getUuid());
                        goodsMapper.managerConfirm_out(element.getUuid(),company_id);
                    } else {
                        System.out.println(element.getUuid());
                        goodsMapper.managerConfirm_out1(element.getUuid(), quantity,company_id);
                        break;
                    }
                }
            }
            goodsMapper.managerConfirm1(uuid,"2",company_id);
        }
        else{
            goodsMapper.managerConfirm1(uuid,"0",company_id);
        }
    }

    public Result<PageVo<ApplyVo>> confirmItem(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<ApplyVo>> result = new Result<>();
        PageVo<ApplyVo> pageVo = new PageVo();
        Integer size = goodsMapper.getConfirmCount(company_id);
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
        List<ApplyVo> currentlist = goodsMapper.selectConfirmAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }






    public Result<PageVo<ApplyVo>> messageItem(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<ApplyVo>> result = new Result<>();
        PageVo<ApplyVo> pageVo = new PageVo();
        Integer size = goodsMapper.getMessageCount(company_id);
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
        List<ApplyVo> currentlist = goodsMapper.selectMessageAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public void remove(String uuid, String user,String company_id){
         ApplyVo applyVo = goodsMapper.getByUuid(uuid,company_id);
         Timestamp timestamp = getTime();

         List<GoodsMessageVo> goodsMessageVoList = goodsMessageMapper.getOrderByGoods(applyVo.getGoods_id(), applyVo.getTypes(),company_id);
         int cnt = applyVo.getQuantity();
         for(GoodsMessageVo goodsMessageVo : goodsMessageVoList){
             if(goodsMessageVo.getQuantity() <= cnt){
                 cnt -= goodsMessageVo.getQuantity();
                 goodsMessageMapper.removeByTime(applyVo.getGoods_id(), goodsMessageVo.getCreated_time(), timestamp, user,company_id);
                 goodsMapper.removeById(goodsMessageVo.getStorage_id(), goodsMessageVo.getShelf_id(), goodsMessageVo.getLocation(), 0, timestamp, user,company_id);
             }else{
                 goodsMapper.removeById(goodsMessageVo.getStorage_id(), goodsMessageVo.getShelf_id(), goodsMessageVo.getLocation(), goodsMessageVo.getQuantity() - cnt, timestamp, user,company_id);
                 List<GoodsMessageVo> goodsMessageVoList1 = goodsMessageMapper.getByTime(goodsMessageVo.getCreated_time(),company_id);
                 for(GoodsMessageVo goodsMessageVo1 : goodsMessageVoList1){
                     cnt--;
                     goodsMessageMapper.delete(goodsMessageVo1.getUuid(), goodsMessageVo.getCreated_time(),company_id);
                     if(cnt == 0)break;
                 }
             }
         }
         goodsMapper.removeApply(uuid, user, timestamp,company_id);
         goodsMapper.checkDelete(company_id);
    }

    public void addGoods(String storage_id, String shelf_id, String location, String id, int quantity, String type, String user,String company_id) throws SQLException {
        String name;
        if(type.equals("material")){
            name = goodsMapper.getMaterial(id,company_id);
            if(name == null)
                throw new SQLException();
        }else{
            name = goodsMapper.getEquipment(id,company_id);
            if(name == null)
                throw new SQLException();
        }
        GoodsVo goodsVo = goodsMapper.getById(storage_id, shelf_id, location,company_id);
        if(goodsVo != null){
            if(!goodsVo.getTypes().equals(type) || !goodsVo.getGoods_id().equals(id)){
                throw new SQLException();
            }
        }
        if(storageMapper.search(storage_id,company_id) == null){
            throw new SQLException();
        }
        if(shelfMapper.getById(storage_id, shelf_id,company_id) == null){
            throw new SQLException();
        }
        ApplyVo applyVo = new ApplyVo();
        setTime(applyVo, user,company_id);
        applyVo.setStorage_id(storage_id);
        applyVo.setShelf_id(shelf_id);
        applyVo.setLocation(location);
        applyVo.setGoods_id(id);
        applyVo.setGoods_name(name);
        applyVo.setTypes(type);
        applyVo.setQuantity(quantity);
        applyVo.setPermit("100");
        applyVo.setCompany_id(company_id);
        goodsMapper.addApply(applyVo);
    }

    public Result<PageVo<ApplyVo>> addItem(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<ApplyVo>> result = new Result<>();
        PageVo<ApplyVo> pageVo = new PageVo();
        Integer size = goodsMapper.getAddCount(company_id);
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
        List<ApplyVo> currentlist = goodsMapper.selectAddAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public void addConfirm(String uuid, String message, String user,String company_id) throws SQLException {
        Timestamp timestamp = getTime();
        goodsMapper.managerConfirm(uuid, "50", user, timestamp,company_id);
        if(message.equals("0")){
            return ;
        }
        ApplyVo applyVo = goodsMapper.getByUuid(uuid,company_id);
        if(storageMapper.search(applyVo.getStorage_id(),company_id) == null){
            throw new SQLException();
        }
        if(shelfMapper.getById(applyVo.getStorage_id(), applyVo.getShelf_id(),company_id) == null){
            throw new SQLException();
        }

        GoodsVo goodsVo = goodsMapper.getById(applyVo.getStorage_id(), applyVo.getShelf_id(), applyVo.getLocation(),company_id);
        if(goodsVo != null){
            if(!goodsVo.getGoods_id().equals(applyVo.getGoods_id()) || !goodsVo.getTypes().equals(applyVo.getTypes())){
                throw new SQLException();
            }
        }
        if(goodsVo != null){
            goodsMapper.updateQuantity(applyVo.getStorage_id(), applyVo.getShelf_id(), applyVo.getLocation(), applyVo.getQuantity() + goodsVo.getQuantity(), timestamp,company_id);
        }else{
            GoodsVo goodsVo1 = new GoodsVo();
            setTime(goodsVo1, user,company_id);
            goodsVo1.setId(applyVo.getLocation());
            goodsVo1.setStorage_id(applyVo.getStorage_id());
            goodsVo1.setShelf_id(applyVo.getShelf_id());
            goodsVo1.setGoods_id(applyVo.getGoods_id());
            goodsVo1.setGoods_name(applyVo.getGoods_name());
            goodsVo1.setQuantity(applyVo.getQuantity());
            goodsVo1.setVerify("normal");
            goodsVo1.setTypes(applyVo.getTypes());
            goodsVo1.setCompany_id(company_id);
            goodsMapper.insert(goodsVo1);

        }
        for(int i = 0; i < applyVo.getQuantity(); i++){
            GoodsMessageVo goodsMessageVo = new GoodsMessageVo();
            setTime(goodsMessageVo, user,company_id);
            goodsMessageVo.setId(applyVo.getGoods_id());
            goodsMessageVo.setStorage_id(applyVo.getStorage_id());
            goodsMessageVo.setShelf_id(applyVo.getShelf_id());
            goodsMessageVo.setLocation(applyVo.getLocation());
            goodsMessageVo.setTypes(applyVo.getTypes());
            goodsMessageVo.setIor("insert");
            goodsMessageVo.setCreated_time(timestamp);
            goodsMessageVo.setModified_time(timestamp);
            goodsMessageVo.setCompany_id(company_id);
            goodsMessageMapper.insert(goodsMessageVo);
        }
    }

    public Result<PageVo<GoodsVo>> goodsItem(String page, String page_size, String storage_id, String shelf_id,String company_id) throws SQLException {
        Result<PageVo<GoodsVo>> result = new Result<>();
        PageVo<GoodsVo> pageVo = new PageVo();
        Integer size = goodsMapper.getGoodsCount(storage_id, shelf_id,company_id);
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
        List<GoodsVo> currentlist = goodsMapper.selectGoodsAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(), storage_id, shelf_id,company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public Result<PageVo<GoodsVo>> locationItem(String page, String page_size, String storage_id, String shelf_id,String company_id) throws SQLException {
        Result<PageVo<GoodsVo>> result = new Result<>();
        PageVo<GoodsVo> pageVo = new PageVo();
        Integer size = goodsMapper.getLocationCount(storage_id, shelf_id,company_id);
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
        List<GoodsVo> currentlist = goodsMapper.selectLocationAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(), storage_id, shelf_id,company_id);
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }
}
