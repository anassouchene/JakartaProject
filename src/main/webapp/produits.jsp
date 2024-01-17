<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produits</title>
</head>
<body>
    <h2>Ajouter un produit</h2>
    <form action="ProduitServlet" method="post">
        <input type="hidden" name="action" value="ajouter">
        Nom du produit: <input type="text" name="nom_produit" required><br>
        Quantité: <input type="number" name="quantite_produit" required><br>
        Catégorie: <input type="text" name="productCategory" required><br>
        Description: <input type="text" name="productdescription" required><br>
        Prix: <input type="number" name="prix_produit" required><br>
        <input type="submit" value="Ajouter">
    </form>

    <h2>Liste des produits</h2>
    <table border="1">
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
    <c:forEach var="produit" items="${produits}">
        <tr>
            <td>${produit.nomProduit}</td>
            <td>${produit.quantiteProduit}</td>
            <td>${produit.productCategory}</td>
            <td>${produit.productDescription}</td>
            <td>${produit.prixProduit}</td>
            <td>
                <form action="ProduitServlet" method="post">
                    <input type="hidden" name="action" value="modifier">
                    <input type="hidden" name="nom_produit" value="${produit.nomProduit}">
                    <!-- Ajout des champs pour la modification -->
                    <input type="hidden" name="newQuantite" value="${produit.quantiteProduit}">
                    <input type="hidden" name="newCategory" value="${produit.productCategory}">
                    <input type="hidden" name="newDescription" value="${produit.productDescription}">
                    <input type="hidden" name="newPrix" value="${produit.prixProduit}">
                    <input type="submit" value="Modifier">
                </form>
                <form action="ProduitServlet" method="post">
                    <input type="hidden" name="action" value="supprimer">
                    <input type="hidden" name="nom_produit" value="${produit.nomProduit}">
                    <input type="submit" value="Supprimer">
                </form>
            </td>
        </tr>
    </c:forEach>
</tbody>
<!-- ... -->
    </table>
</body>
</html>
