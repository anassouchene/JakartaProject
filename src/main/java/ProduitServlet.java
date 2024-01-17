package stock;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProduitServlet extends HttpServlet {
    private MethodeProduit methodeProduit = new MethodeProduit();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produit> produits = methodeProduit.selectProduits();
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("produits.jsp").forward(request, response);
        System.out.print(produits);
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

            // Vérifiez si les paramètres pour la modification sont présents
            if (newQuantiteParam != null && newPrixParam != null) {
                int newQuantite = Integer.parseInt(newQuantiteParam);
                int newPrix = Integer.parseInt(newPrixParam);
                methodeProduit.modifierProduit(nomProduit, newQuantite, newCategory, newDescription, newPrix);
            }
        } else if (action.equals("supprimer")) {
            String nomProduit = request.getParameter("nom_produit");
            methodeProduit.supprimerProduit(nomProduit);
        }
        // Redirigez vers la page de produits après avoir effectué l'action
        response.sendRedirect("ProduitServlet.java");
    }
}
