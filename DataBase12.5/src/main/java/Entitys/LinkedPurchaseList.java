package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    public LinkedPurchaseList() {
    }

    @EmbeddedId
    private Key id;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseList that = (LinkedPurchaseList) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
