package ru.itcrown.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bill extends AbstractModel{

    private String number;
    private Date billDate;
    private Map<Usluga, Long> uslugaMap=new HashMap<>();
    private BigDecimal totalPrice;
    private Organization organization;

    public void addUslugaToBill(Usluga usluga, Long quantity){
        if(uslugaMap.containsKey(usluga)) uslugaMap.put(usluga, uslugaMap.get(usluga)+quantity);
        else uslugaMap.put(usluga,quantity);
    }

    public void removeUslugaFromBill(Usluga usluga, Long quantity){
        if(uslugaMap.containsKey(usluga)){
            if(uslugaMap.get(usluga)>quantity) uslugaMap.put(usluga,uslugaMap.get(usluga)-quantity);
            else uslugaMap.remove(usluga);
        }
    }

}
