package br.study.jpa.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.study.jpa.model.domain.Position;

@Entity
@Table(name = "JOB_OPPORTUNITY")
public class JobOpportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "job_id")
    private Long id;

    @Enumerated
    private Position position;

    private LocalDateTime dateStartAnnounce;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // --- Getters && Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // ------ EQUAL AND HASH

    public LocalDateTime getDateStartAnnounce() {
        return dateStartAnnounce;
    }

    public void setDateStartAnnounce(LocalDateTime dateStartAnnounce) {
        this.dateStartAnnounce = dateStartAnnounce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JobOpportunity review = (JobOpportunity) o;

        if (!position.equals(review.position)) {
            return false;
        }
        if (!restaurant.equals(review.restaurant)) {
            return false;
        }
        return dateStartAnnounce.equals(review.dateStartAnnounce);
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + position.hashCode();
        result = 31 * result + restaurant.hashCode();
        result = 31 * result + dateStartAnnounce.hashCode();
        return result;
    }
}
