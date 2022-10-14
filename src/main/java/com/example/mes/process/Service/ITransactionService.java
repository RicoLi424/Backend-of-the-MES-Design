package com.example.mes.process.Service;

import com.example.mes.process.Vo.TransactionVo.*;

public interface ITransactionService {

    //增加产品、工艺路线概述、工艺路线详细信息、物料清单
    String add(InsertVo insertVo);
    //增加产品、工艺路线概述、工艺路线详细信息、物料清单
    String add2(InsertVopro insertVopro);
    String add3(InsertVo insertVo);
    //修改产品、工艺路线概述、工艺路线详细信息、物料清单
    String update(UpdateVo updateVo);
    //修改产品、工艺路线概述、工艺路线详细信息、物料清单
    String update2(UpdateVopro updateVopro);
    //根据产品id获得产品的工艺路线概述、工艺路线具体信息、物料清单信息
    QueryVo getInfosByID(String product_id);



}
