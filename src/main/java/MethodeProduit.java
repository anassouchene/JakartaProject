package org.example.jeeproject.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MethodeProduit {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jee-project";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    public void ajouterProduit(String nomProduit, int quantiteProduit, String productCategory, String productDescription, int prixProduit) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO stock (nom_produit, quantite_produit, productCategory, productdescription, prix_produit) VALUES (?, ?, ?, ?, ?)"))
        {
            statement.setString(1, nomProduit);
            statement.setInt(2, quantiteProduit);
            statement.setString(3, productCategory);
            statement.setString(4, productDescription);
            statement.setInt(5, prixProduit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Produit> selectProduits() {
        List<Produit> produits = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM stock");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nomProduit = resultSet.getString("nom_produit");
                int quantiteProduit = resultSet.getInt("quantite_produit");
                String productCategory = resultSet.getString("productCategory");
                String productDescription = resultSet.getString("productdescription");
                int prixProduit = resultSet.getInt("prix_produit");

                Produit produit = new Produit(nomProduit, quantiteProduit, prixProduit, productCategory, productDescription);
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }
    public void modifierProduit(String nomProduit, int newQuantite, String newCategory, String newDescription, int newPrix) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE stock SET quantite_produit=?, productCategory=?, productdescription=?, prix_produit=? WHERE nom_produit=?")) {
            statement.setInt(1, newQuantite);
            statement.setString(2, newCategory);
            statement.setString(3, newDescription);
            statement.setInt(4, newPrix);
            statement.setString(5, nomProduit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerProduit(String nomProduit) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM stock WHERE nom_produit=?")) {
            statement.setString(1, nomProduit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
