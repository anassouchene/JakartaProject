package org.example.jeeproject.Product;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private MethodeProduit methodeProduit = new MethodeProduit();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produit> produits = methodeProduit.selectProduits();
        if (produits != null) {
            request.setAttribute("produits", produits);
        }
        request.getRequestDispatcher("/produits.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("ajouter")) {
            String nomProduit = request.getParameter("nom_produit");
            int quantiteProduit = Integer.parseInt(request.getParameter("quantite_produit"));
            String productCategory = request.getParameter("productCategory");
            String productDescription = request.getParameter("productdescription");
            int prixProduit = Integer.parseInt(request.getParameter("prix_produit"));
            methodeProduit.ajouterProduit(nomProduit, quantiteProduit, productCategory, productDescription, prixProduit);
        } else if (action.equals("modifier")) {
            String nomProduit = request.getParameter("nom_produit");
            String newQuantiteParam = request.getParameter("newQuantite");
            String newCategory = request.getParameter("newCategory");
            String newDescription = request.getParameter("newDescription");
            String newPrixParam = request.getParameter("newPrix");

            if (newQuantiteParam != null && newPrixParam != null) {
                int newQuantite = Integer.parseInt(newQuantiteParam);
                int newPrix = Integer.parseInt(newPrixParam);
                methodeProduit.modifierProduit(nomProduit, newQuantite, newCategory, newDescription, newPrix);
            }
        } else if (action.equals("supprimer")) {
            String nomProduit = request.getParameter("nom_produit");
            methodeProduit.supprimerProduit(nomProduit);
        }
        response.sendRedirect(request.getContextPath() + "/ProductServlet");
    }
}
