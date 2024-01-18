<%@ page import="org.example.jeeproject.Product.Produit" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produits</title>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<% String successMessage = (String) request.getAttribute("successMessage");
    if (successMessage != null && !successMessage.isEmpty()) { %>
<div class="alert alert-success" role="alert">
    <%= successMessage %>
</div>
<% } %>

<div class="container mt-4">
    <h2>Ajouter un produit</h2>
    <form action="ProductServlet" method="post">
        <input type="hidden" name="action" value="ajouter">
        <div class="form-group">
            <label for="nom_produit">Nom du produit:</label>
            <input type="text" name="nom_produit" class="form-control" id="nom_produit" required>
        </div>
        <div class="form-group">
            <label for="quantite_produit">Quantité:</label>
            <input type="number" name="quantite_produit" class="form-control" id="quantite_produit" required>
        </div>
        <div class="form-group">
            <label for="productCategory">Catégorie:</label>
            <select name="productCategory" class="form-control" id="productCategory" required>
                <option value="Outils a main">Outils a main</option>
                <option value="Outils electriques">Outils electriques</option>
                <option value="Outils de mesure">Outils de mesure</option>
            </select>
        </div>
        <div class="form-group">
            <label for="productdescription">Description:</label>
            <input type="text" name="productdescription" class="form-control" id="productdescription" required>
        </div>
        <div class="form-group">
            <label for="prix_produit">Prix:</label>
            <input type="number" name="prix_produit" class="form-control" id="prix_produit" required>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>

    <h2>Liste des produits</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Catégorie</th>
            <th>Description</th>
            <th>Prix</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% List<Produit> produits = (List<Produit>) request.getAttribute("produits");
            if (produits != null && !produits.isEmpty()) {
                for (Produit produit : produits) { %>
        <tr>
            <td><%= produit.getNomProduit() %></td>
            <td><%= produit.getQuantiteProduit() %></td>
            <td><%= produit.getProductCategory() %></td>
            <td><%= produit.getProductDescription() %></td>
            <td><%= produit.getPrixProduit() %></td>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modifierProduitModal_<%= produit.getNomProduit() %>">
                    Modifier
                </button>
                <form style="display: inline;" action="ProductServlet" method="post">
                    <input type="hidden" name="action" value="supprimer">
                    <input type="hidden" name="nom_produit" value="<%= produit.getNomProduit() %>">
                    <button type="submit" class="btn btn-danger">Supprimer</button>
                </form>
            </td>
        </tr>

        <div class="modal fade" id="modifierProduitModal_<%= produit.getNomProduit() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modifier Produit - <%= produit.getNomProduit() %></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="ProductServlet" method="post">
                            <input type="hidden" name="action" value="modifier">
                            <input type="hidden" name="nom_produit" value="<%= produit.getNomProduit() %>">
                            <div class="form-group">
                                <label for="newQuantite_<%= produit.getNomProduit() %>">Quantité:</label>
                                <input type="number" class="form-control" name="newQuantite" id="newQuantite_<%= produit.getNomProduit() %>" value="<%= produit.getQuantiteProduit() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="newCategory_<%= produit.getNomProduit() %>">Catégorie:</label>
                                <select name="newCategory" class="form-control" id="newCategory_<%= produit.getNomProduit() %>" required>
                                    <option value="Outils a main" <%= produit.getProductCategory().equals("Outils a main") ? "selected" : "" %>>Outils a main</option>
                                    <option value="Outils electriques" <%= produit.getProductCategory().equals("Outils electriques") ? "selected" : "" %>>Outils electriques</option>
                                    <option value="Outils de mesure" <%= produit.getProductCategory().equals("Outils de mesure") ? "selected" : "" %>>Outils de mesure</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="newDescription_<%= produit.getNomProduit() %>">Description:</label>
                                <input type="text" class="form-control" name="newDescription" id="newDescription_<%= produit.getNomProduit() %>" value="<%= produit.getProductDescription() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="newPrix_<%= produit.getNomProduit() %>">Prix:</label>
                                <input type="number" class="form-control" name="newPrix" id="newPrix_<%= produit.getNomProduit() %>" value="<%= produit.getPrixProduit() %>" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Modifier Produit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <% } } else { %>
        <tr>
            <td colspan="6">Aucun produit disponible.</td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <div class="modal fade" id="listeProduitsModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel_listeProduits">Liste des Produits</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Nom</th>
                            <th scope="col">Quantité</th>
                            <th scope="col">Catégorie</th>
                            <th scope="col">Description</th>
                            <th scope="col">Prix</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% if (produits != null && !produits.isEmpty()) {
                            for (Produit produit : produits) { %>
                        <tr>
                            <td><%= produit.getNomProduit() %></td>
                            <td><%= produit.getQuantiteProduit() %></td>
                            <td><%= produit.getProductCategory() %></td>
                            <td><%= produit.getProductDescription() %></td>
                            <td><%= produit.getPrixProduit() %></td>
                        </tr>
                        <% } } else { %>
                        <tr>
                            <td colspan="5">Aucun produit disponible.</td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
