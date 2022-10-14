package com.example.mes.dataAnalysis.Vo;

public class ProductionSchedule {

    int demand_quantity;
    int produced_quantity;


    public ProductionSchedule() {
    }

    public ProductionSchedule(int demand_quantity, int produced_quantity) {
        this.demand_quantity = demand_quantity;
        this.produced_quantity = produced_quantity;
    }

    public int getDemand_quantity() {
        return demand_quantity;
    }

    public void setDemand_quantity(int demand_quantity) {
        this.demand_quantity = demand_quantity;
    }

    public int getProduced_quantity() {
        return produced_quantity;
    }

    public void setProduced_quantity(int produced_quantity) {
        this.produced_quantity = produced_quantity;
    }

    @Override
    public String toString() {
        return "ProductionSchedule{" +
                "demand_quantity=" + demand_quantity +
                ", produced_quantity=" + produced_quantity +
                '}';
    }
}
