package Listings;

import Products.*;
import Regions.*;

public class Listing
{
        private String id;
        private Product product;
        private Region region;
        private String ownerId;
        private String expiryDate;
        private Boolean isVip;
        private String description;
        private Boolean isService = false;

        public Listing(String id, Product product, Region region, String ownerId, String expiryDate, Boolean isVip, String description) {
            this.id = id;
            this.product = product;
            this.region = region;
            this.ownerId = ownerId;
            this.expiryDate = expiryDate;
            this.isVip = isVip;
            this.description = description;
            this.isService = false;
        }

        public Listing(String id, Region region, String ownerId, String expiryDate, Boolean isVip, String description) {
            this.id = id;
            this.product = null;
            this.region = region;
            this.ownerId = ownerId;
            this.expiryDate = expiryDate;
            this.isVip = isVip;
            this.description = description;
            this.isService = true;
        }

        public String getId() {
            return id;
        }

        public Product getProduct() {
            return product;
        }

        public Region getRegion() {
            return region;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public Boolean getIsVip() {
            return isVip;
        }

        public String getDescription() {
            return description;
        }

        public Boolean getIsService() {
            return isService;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public void setRegion(Region region) {
            this.region = region;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public void setIsVip(Boolean isVip) {
            this.isVip = isVip;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIsService(Boolean isService) {
            this.isService = isService;
        }

        public Listing getCopy() {
            return new Listing(this.id, this.product, this.region, this.ownerId,
                               this.expiryDate, this.isVip, this.description);
        }

        public String toString() {
            return "Listing{" +
                    "id='" + id + '\'' +
                    ", product=" + (product != null ? product.toString() : "null") +
                    ", region=" + (region != null ? region.toString() : "null") +
                    ", ownerId='" + ownerId + '\'' +
                    ", expiryDate='" + expiryDate + '\'' +
                    ", isVip=" + isVip +
                    ", description='" + description + '\'' +
                    ", isService=" + isService +
                    '}';
        }
    }