package net.zz.validator.demo.entity;

import net.zz.validator.constraints.IdCard;
import net.zz.validator.constraints.QQ;
import net.zz.validator.plug.MsgCode;

import javax.validation.constraints.NotNull;

/**
 * Created by ZaoSheng on 2015/7/2.
 */
public class User {
    @MsgCode(1001011)
    @NotNull
    private String name;
    @QQ
    private String qq;
    @IdCard
    private String idCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
