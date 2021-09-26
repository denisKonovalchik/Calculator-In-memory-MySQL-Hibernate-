package by.konovalchik.services.ValueListHandler;

import by.konovalchik.entity.Operation;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OperationsListHandler {
    private  final List<Operation> operations;

    public OperationsListHandler(List<Operation> operations) {
        this.operations = operations;
    }

    public int getSize() {
        return operations.size();
    }

    public List<Operation> getListElement(int page, int valuesPage) {
         List<Operation> list = new ArrayList<>();
         if(page == 1) {
                 if (getSize() >= valuesPage){
                     for (int i = 0; i < valuesPage; i++) {
                         list.add(operations.get(i));
                     }
                 }else {
                     for (int i = 0; i < getSize(); i++) {
                         list.add(operations.get(i));
                     }
                 }
         }else{
                 if((getSize() - (page*valuesPage-valuesPage)) >= valuesPage){
                         for(int i = (page*valuesPage-valuesPage); i < (page*valuesPage); i++ ){
                             list.add(operations.get(i));
                         }
                 }else {
                    for (int i = (page*valuesPage-valuesPage); i < getSize(); i++) {
                        list.add(operations.get(i));
                    }
                 }
         }
        return list;
    }

}
