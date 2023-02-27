package cn.lanqiao.springboot3.entity;

public class SaleGoods {
    private Integer id;
    private String goodsName;
    private float weight;
    private int type;
    private Boolean onSale;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public Boolean getOnSale() {
        return onSale;
    }
    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "SaleGoods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", weight=" + weight +
                ", type=" + type +
                ", onSale=" + onSale +
                '}';
    }
}
