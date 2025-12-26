package com.example.SKILL_2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
@Id
 int id;
String name;
String description;
 Double price;
 Double quantity;
 public int getId() {
	return id;
 }
 public void setId(int id) {
	this.id = id;
 }
 public String getName() {
	return name;
 }
 public void setName(String name) {
	this.name = name;
 }
 public String getDescription() {
	return description;
 }
 public void setDescription(String description) {
	this.description = description;
 }
 public Double getPrice() {
	return price;
 }
 public void setPrice(double i) {
	this.price = i;
 }
 public Double getQuantity() {
	return quantity;
 }
 public void setQuantity(double i) {
	this.quantity = i;
 }
 
}
