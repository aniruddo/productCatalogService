package com.ecommerce.productcatalogservice.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name ="tpc_mentor")
public class Mentor extends User {
    private Long hours;
}
