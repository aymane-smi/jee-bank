<%@ include file="/WEB-INF/assets/header.jsp" %>
<div class="container">
    <p class="title">Modifier Employee</p>
    <a href="${pageContext.servletContext.contextPath}/employee">revenir vers liste des employees ></a>
<form action="${pageContext.servletContext.contextPath}/employee/edit/${employee.registrationNbr}" method="POST" class="costum-form">
    <div>
        <label for="firstName">Nom</label>
        <input id="firstName" type="text" name="firstName" value="${employee.firstName}"/>
    </div>
    <div>
        <label for="lastName">Prenom</label>
        <input id="lastName" type="text" name="lastName" value="${employee.lastName}"/>
    </div>
    <div>
        <label for="birthDay">date de naissance</label>
        <input id="birthDay" type="date" name="birthDay" value="${employee.birthDay}"/>
    </div>
    <div>
        <label for="phone">Telephone</label>
        <input id="phone" type="text" name="phone" value="${employee.phone}"/>
    </div>
    <div>
        <label for="address">Adresse</label>
        <textarea id="address" name="address">${employee.address}</textarea>
    </div>
    <div>
        <label for="dateOfRecrutement">Date de recrutement</label>
        <input id="dateOfRecrutement" type="date" name="dateOfRecrutement" value="${employee.dateOfRecrutment}"/>
    </div>
    <div>
        <label for="agencyCode">Agence</label>
        <select id="agencyCode" name="agencyCode">
            <c:forEach items="${agencies}" var="agency">
                <option value="${agency.code}" >${agency.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="agencyDate">Date de affectation dans l'agence</label>
        <input id="agencyDate" type="date" name="agencyDate"/>
    </div>
    <button class="edit-btn2">Modifier</button>
</form>
</div>
<%@ include file="/WEB-INF/assets/footer.jsp" %>