package com.example.mes.WorkshopStorage.service;

import com.example.mes.WorkshopStorage.mapper.ShelfMapper;
import com.example.mes.WorkshopStorage.mapper.StorageMapper;
import com.example.mes.WorkshopStorage.para.Shelfpara;
import com.example.mes.WorkshopStorage.para.StoragePara;
import com.example.mes.WorkshopStorage.vo.PageVo;
import com.example.mes.WorkshopStorage.vo.Result;
import com.example.mes.WorkshopStorage.vo.ShelfVo;
import com.example.mes.WorkshopStorage.vo.StorageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class StorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Autowired
    private ShelfMapper shelfMapper;

    public Result<PageVo<StorageVo>> storageItem(String page, String page_size,String company_id) throws SQLException {
        Result<PageVo<StorageVo>> result = new Result<>();
        PageVo<StorageVo> pageVo = new PageVo();
        Integer size = storageMapper.getCount(company_id);
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
        List<StorageVo> currentlist = storageMapper.selectAll((pageVo.getCurrent() - 1) * Integer.parseInt(page_size), pageVo.getPages(),company_id);
        for(StorageVo storageVo : currentlist){
            Integer cnt;
            cnt = shelfMapper.getShelfNumByStorageId(storageVo.getId(),company_id);
            if(cnt != null){
                storageVo.setShelf_Num(cnt);
            }
        }
        pageVo.setRecords(currentlist);
        result.setResult(pageVo);
        return result;
    }

    public void delete(String storage_id, String user,String company_id) throws SQLException {
        Integer cnt = shelfMapper.getShelfNumByStorageId(storage_id,company_id);
        if(cnt == 0){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            storageMapper.delete(storage_id, user, timestamp,company_id);
        }else{
            throw new SQLException();
        }
    }

    public List<StorageVo> all_storage(String company_id){
        List<StorageVo> list = storageMapper.all_storage(company_id);
        return list;
    }

    public Result<StorageVo> search(String storage_id,String company_id){
        Result<StorageVo> storageVoResult = new Result<>();
        StorageVo storageVo = storageMapper.search(storage_id,company_id);
        storageVo.setShelf_Num(shelfMapper.getShelfNumByStorageId(storage_id,company_id));
        storageVoResult.setResult(storageVo);
        return storageVoResult;
    }

    public void create(StoragePara params) throws SQLException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());;
        if(storageMapper.search(params.getStorage_id(),params.getCompany_id()) != null){
            throw new SQLException();
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        StorageVo storageVo = new StorageVo();
        storageVo.setUuid(UUID.randomUUID().toString().replace("-", ""));
        storageVo.setId(params.getStorage_id());
        storageVo.setStatus("1");
        storageVo.setIs_deleted("0");
        storageVo.setCreated_by(params.getUser());
        storageVo.setCreated_time(timestamp);
        storageVo.setModified_by(params.getUser());
        storageVo.setModified_time(timestamp);
        storageVo.setCompany_id(params.getCompany_id());
        storageMapper.create(storageVo);
        for(Shelfpara shelfpara : params.getShelfs()){
            ShelfVo shelfVo = new ShelfVo();
            shelfVo.setUuid(UUID.randomUUID().toString().replace("-", ""));
            shelfVo.setId(shelfpara.getShelf_id());
            shelfVo.setStorage_id(params.getStorage_id());
            shelfVo.setStatus("1");
            shelfVo.setIs_deleted("0");
            shelfVo.setCreated_by(params.getUser());
            shelfVo.setCreated_time(timestamp);
            shelfVo.setModified_by(params.getUser());
            shelfVo.setModified_time(timestamp);
            shelfVo.setCompany_id(params.getCompany_id());
            shelfMapper.insert(shelfVo);
        }
    }
}
