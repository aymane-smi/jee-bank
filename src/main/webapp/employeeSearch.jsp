<%@ include file="/WEB-INF/assets/header.jsp" %>
<main>
    <div class="simple-nav">
        <span></span>
        <h1>Recherche d'un employee</h1>
        <form class="form-search" action="${pageContext.servletContext.contextPath}/employee/search" method="post">
            <input type="text" name="searchMatricule" class="search-employee" placeholder="matricule d'employee">
        </form>
    </div>
    <a href="${pageContext.servletContext.contextPath}/employee" class="goback-btn">
        revenir vers liste des employees >
    </a>
    <c:if test="${employee != null}">
        <table>
        <thead>
        <tr>
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Date de naissance</th>
            <th>Telephone</th>
            <th>Adresse</th>
            <th>Date de recrutement</th>
            <th>Nom d'agence</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${employee.registrationNbr}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.birthDay}</td>
                <td>${employee.phone}</td>
                <td>${employee.address}</td>
                <td>${employee.dateOfRecrutment}</td>
                <td>${employee.agency.name}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/employee/edit/${employee.registrationNbr}">
                        <i class="bi bi-pencil"></i>
                    </a>
                    <form class="form-delete" method="POST" action="${pageContext.servletContext.contextPath}/employee/delete/${employee.registrationNbr}">
                        <button class="btn-delete">
                            <i class="bi bi-trash-fill"></i>
                        </button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
    </c:if>
</main>
<%@ include file="/WEB-INF/assets/footer.jsp" %>