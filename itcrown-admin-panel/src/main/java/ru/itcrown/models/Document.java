package ru.itcrown.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Document extends AbstractModel{

    private Date date;
    private BigDecimal totalSum;
    private Map<Usluga, Long> uslugaMap=new HashMap<>();

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
