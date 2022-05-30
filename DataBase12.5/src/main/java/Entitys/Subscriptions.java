package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @EmbeddedId
    private SubscriptionKey subscriptionKey;


    @Column(name = "subscription_date", nullable = false)
    private LocalDateTime subscriptionDate;


    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriptions that = (Subscriptions) o;
        return Objects.equals(subscriptionKey, that.subscriptionKey) && Objects.equals(subscriptionDate, that.subscriptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionKey, subscriptionDate);
    }




}


