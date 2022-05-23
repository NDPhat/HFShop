<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/11/2021
  Time: 04:36 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<base href="${pageContext.request.contextPath}/project/">

<jsp:include page="headerAdmin.jsp"/>
    <main class="page-content">
    <div class="container">
        <div class="page-header">
            <h1 class="page-header__title">Account</h1>
        </div>
        <div class="page-tools">
            <div class="page-tools__breadcrumbs">
                <div class="breadcrumbs">
                    <div class="breadcrumbs__container">
                        <ol class="breadcrumbs__list">
                            <li class="breadcrumbs__item">
                                <a class="breadcrumbs__link" href="index.html">
                                    <svg class="icon-icon-home breadcrumbs__icon">
                                        <use xlink:href="#icon-home"></use>
                                    </svg>
                                    <svg class="icon-icon-keyboard-right breadcrumbs__arrow">
                                        <use xlink:href="#icon-keyboard-right"></use>
                                    </svg>
                                </a>
                            </li>
                            <li class="breadcrumbs__item disabled"><a class="breadcrumbs__link" href="#"><span>Customer Manager</span>
                                <svg class="icon-icon-keyboard-right breadcrumbs__arrow">
                                    <use xlink:href="#icon-keyboard-right"></use>
                                </svg></a>
                            </li>
                            <li class="breadcrumbs__item active"><span class="breadcrumbs__link">Account</span>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
            <div class="page-tools__right">
                <div class="page-tools__right-row">
                    <div class="page-tools__right-item" onclick="bancustom(${requestScope.users.getId()})"><a class="button-icon" href="#"><span class="button-icon__icon">
                      <svg class="icon-icon-task">
                        <use xlink:href="#icon-task"></use>
                      </svg></span></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="customer-account">
            <div class="customer-account__item-1 customer-profile customer-card card">
                <div class="card__wrapper">
                    <div class="card__container">
                        <div class="customer-profile__balance">
                            <div id="role-name" class="label label--primary label--lg" style="background-color:burlywood;"><c:out value="${requestScope.role}"/></div>
                        </div>
                        <div class="card__body">
                            <div class="customer-profile__avatar">
									<image id="profileImage" width="400" height="400" src="<c:out value='${pageContext.request.contextPath}/uploads/${users.getImage()}' />"
									alt="IMG-PRODUCT" />
                                   
                            </div>
                            <h4 class="customer-profile__title"><c:out  value="${users.getName()}"/>  </h4>
                          
                        </div>
                        <div class="card__footer">
                            <div class="card__container">
                                <ul class="customer-profile__address">
                                    <li>
                                        <svg class="icon-icon-location">
                                            <use xlink:href="#icon-location"></use>
                                        </svg><c:out  value="${users.getAddress()}"/>
                                    </li>
                                    <li>
                                        <svg class="icon-icon-email">
                                            <use xlink:href="#icon-email"></use>
                                        </svg> <a href="mailto:#">
                                        <c:out  value="${users.getEmail()}"/></a>
                                    </li>
                                    <li>
                                        <svg class="icon-icon-phone">
                                            <use xlink:href="#icon-phone"></use>
                                        </svg> <a href="tel:#"><c:out  value="${users.getPhone()}"/></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="customer-account__item-2 customer-details customer-card card">
                <div class="card__wrapper">
                    <div class="card__container">
                        <div class="card__header">
                            <div class="card__header-left">
                                <h3 class="card__header-title">Account Details</h3>
                            </div>
                            <div class="customer-card__header-right">
                                <button class="customer-card__btn-task">
                                    <svg class="icon-icon-task">
                                        <use xlink:href="#icon-task"></use>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="card__body">
                            <ul class="customer-details__list">
                                <li>
                                    <div class="row row--xs justify-content-between">
                                        <div class="col-auto text-grey">Name</div>
                                        <div class="col-auto"><c:out  value="${requestScope.users.getName()}"/></div>
                                    </div>
                                </li>
                               
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="customer-account__item-4 customer-shipping customer-card card">
                <div class="card__wrapper">
                    <div class="card__container">
                        <div class="card__header">
                            <div class="card__header-left">
                                <h3 class="card__header-title">Shipping Address</h3>
                            </div>
                            <div class="customer-card__header-right">
                                <button class="customer-card__btn-task">
                                    <svg class="icon-icon-task">
                                        <use xlink:href="#icon-task"></use>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="card__body">
                            <ul class="customer-shipping__list">
                                <li>
                                    <div class="row row--xs justify-content-between">
                                        <div class="col-auto text-grey">Address</div>
                                        <div class="col-auto"><c:out value="${users.getAddress()}"/></div>
                                    </div>
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="customer-account__item-5 customer-shipping customer-card card">
                <div class="card__wrapper">
                    <div class="card__container">
                        <div class="card__header">
                            <div class="card__header-left">
                                <h3 class="card__header-title">Orders List</h3>
                            </div>
                            <div class="customer-card__header-right">
                                <button class="customer-card__btn-task">
                                    <svg class="icon-icon-task">
                                        <use xlink:href="#icon-task"></use>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="card__body">
                            <div class="table-wrapper">
                                <div class="table-wrapper__content table-collapse scrollbar-thin scrollbar-visible" data-simplebar>
                                    <table  class="table table--lines">
                                        <colgroup>
                                            <col width="150px">
                                            <col width="16%">
                                            <col>
                                            <col>
                                            <col>
                                            <col>
                                            <col>
                                        </colgroup>
                                        <thead class="table__header">
                                        <tr class="table__header-row">
                                            </th>
                                            <th class="d-none d-lg-table-cell"><span>Order ID</span>
                                            </th>
                                            <th class="table__th-sort"><span class="align-middle">Total</span>
                                            </th>
                                            <th class="table__th-sort"><span class="align-middle">Date</span>
                                            </th>
                                            <th class="table__th-sort d-none d-sm-table-cell"><span class="align-middle">Status</span>
                                            </th>
                                            <th class="table__actions">Detail</th>
                                        </tr>
                                        </thead>
                                        <tbody id="order-table">


                                        </tbody>
                                    </table>
                                </div>
                                <div class="table-wrapper__footer">
                                    <div class="row">
                                        <div class="table-wrapper__show-result col text-grey" id="info-show">
                                        </div>
                                        <div class="table-wrapper__pagination col-auto">
                                            <ol class="pagination">
                                                <li class="pagination__item" id="previous">
                                                    <a class="pagination__arrow pagination__arrow--prev" >
                                                        <svg class="icon-icon-keyboard-left">
                                                            <use xlink:href="#icon-keyboard-left"></use>
                                                        </svg>
                                                    </a>
                                                </li>
                                                <li class="pagination__item active" id="pagination_first"  data-value=1><a class="pagination__link">1</a>
                                                </li>
                                                <li class="pagination__item pagination__item--dots" id="pagination_space_1">...</li>
                                                <li class="pagination__item" id="pagination_2" data-value = 2><a class="pagination__link" >2</a>
                                                </li>
                                                <li class="pagination__item" id="pagination_3" data-value = 3><a class="pagination__link" >3</a>
                                                </li>
                                                <li class="pagination__item" id="pagination_4" data-value = 4><a class="pagination__link" >4</a>
                                                </li>
                                                <li class="pagination__item pagination__item--dots" id="pagination_space_2">...</li>
                                                <li class="pagination__item" id="pagination_last" data-value = 10><a class="pagination__link" >10</a>
                                                </li>
                                                <li class="pagination__item" id="next">
                                                    <a class="pagination__arrow pagination__arrow--next">
                                                        <svg class="icon-icon-keyboard-right">
                                                            <use xlink:href="#icon-keyboard-right"></use>
                                                        </svg>
                                                    </a>
                                                </li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<script>
    function bancustom(id){
        $.ajax({
            type : "POST",
            data : {
                Id : id
            },
            url : "/admin/customer"
        });
        location.reload();
    }
</script>
<script src="Admin/assets/js/custom/customerAccount.js"></script>
<jsp:include page="footerAdmin.jsp"/>
