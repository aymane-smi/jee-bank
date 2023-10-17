<%@ include file="/WEB-INF/assets/header.jsp" %>
<div class="module">
    <form action="${pageContext.servletContext.contextPath}/employee" method="POST">
        <span class="close">X</span>
        <div class="input-label">
            <label for="firstName">Nom</label>
            <input id="firstName" type="text" name="firstName"/>
        </div>
        <div class="input-label">
            <label for="lastName">Prenom</label>
            <input id="lastName" type="text" name="lastName"/>
        </div>
        <div class="input-label">
            <label for="birthDay">date de naissance</label>
            <input id="birthDay" type="date" name="birthDay"/>
        </div>
        <div class="input-label">
            <label for="phone">Telephone</label>
            <input id="phone" type="text" name="phone"/>
        </div>
        <div class="input-label">
            <label for="address">Adresse</label>
            <textarea id="address" name="address"></textarea>
        </div>
        <div class="input-label">
            <label for="dateOfRecrutement">Date de recrutement</label>
            <input id="dateOfRecrutement" type="date" name="dateOfRecrutement"/>
        </div>
        <div class="input-label">
            <label for="agencyCode">Agence</label>
            <select id="agencyCode" name="agencyCode">
                <c:forEach items="${agencies}" var="agency">
                    <option value="${agency.code}">${agency.name}</option>
                </c:forEach>
            </select>
            <div class="input-label">
                <label for="agencyDate">Date de affectation dans l'agence</label>
                <input id="agencyDate" type="date" name="agencyDate"/>
            </div>
        </div>
        <button class="add-btn2">Ajouter</button>
    </form>
</div>
<main>
    <div class="simple-nav">
        <span></span>
        <h1>liste des Employees</h1>
        <div class="btns">
            <a class="search-btn" href="${pageContext.servletContext.contextPath}/employee/search">chercher un employee</a>
            <button class="add-btn">Ajouter un employee</button>
        </div>
    </div>
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
            <c:forEach items="${employees}" var="employee">
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
            </c:forEach>
</tbody>
</table>
</main>
<%@ include file="/WEB-INF/assets/footer.jsp" %>
