package ru.itcrown.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Data
public class Document extends AbstractModel{

    private Date date;
    private BigDecimal totalSum;
    private Map<Usluga, Long> uslugaMap=new HashMap<>();

    public Document(Long id, Date date, BigDecimal totalSum) {
        setId(id);
        this.date = date;
        this.totalSum = totalSum;
    }

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
