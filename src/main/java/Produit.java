package org.example.jeeproject.Product;

public class Produit {

    private String nomProduit;
    private int quantiteProduit;
    private int prixProduit;
    private String productCategory;
    private String productDescription;

    public Produit(String nomProduit, int quantiteProduit, int prixProduit, String productCategory, String productDescription) {
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.prixProduit = prixProduit;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
    }

    // Getter methods
    public String getNomProduit() {
        return nomProduit;
    }

    public int getQuantiteProduit() {
        return quantiteProduit;
    }

    public int getPrixProduit() {
        return prixProduit;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    // Setter methods
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public void setPrixProduit(int prixProduit) {
        this.prixProduit = prixProduit;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
