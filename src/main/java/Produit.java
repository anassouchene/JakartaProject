


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

    public String getNomProduit() {
        return this.nomProduit;
    }

    public int getQuantiteProduit() {
        return this.quantiteProduit;
    }

    public String getProductCategory() {
        return this.productCategory;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setQuantiteProduit(int quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(int prixProduit) {
        this.prixProduit = prixProduit;
    }
}
