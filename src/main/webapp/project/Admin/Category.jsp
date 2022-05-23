<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/11/2021
  Time: 08:50 am
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<base href="${pageContext.request.contextPath}/project/">

<jsp:include page="headerAdmin.jsp"/>
<main class="page-content">
    <div class="container">
        <div class="page-header" >
            <h1 class="page-header__title">Categories <span class="text-grey" id="number-category">(50)</span></h1>
        </div>
        <div class="page-tools">
            <div class="page-tools__breadcrumbs">
                <div class="breadcrumbs">
                    <div class="breadcrumbs__container">
                        <ol class="breadcrumbs__list">
                            <li class="breadcrumbs__item">
                                <a class="breadcrumbs__link" href="/admin">
                                    <svg class="icon-icon-home breadcrumbs__icon">
                                        <use xlink:href="#icon-home"></use>
                                    </svg>
                                    <svg class="icon-icon-keyboard-right breadcrumbs__arrow">
                                        <use xlink:href="#icon-keyboard-right"></use>
                                    </svg>
                                </a>
                            </li>
                            <li class="breadcrumbs__item disabled"><a class="breadcrumbs__link" href="#"><span>Admin</span>
                                <svg class="icon-icon-keyboard-right breadcrumbs__arrow">
                                    <use xlink:href="#icon-keyboard-right"></use>
                                </svg></a>
                            </li>
                            <li class="breadcrumbs__item active"><span class="breadcrumbs__link">Categories</span>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
            <div class="page-tools__right">
                <div class="page-tools__right-row">
                    <div class="page-tools__right-item"><a class="button-icon" href="#"><span class="button-icon__icon">
                          <svg class="icon-icon-print">
                            <use xlink:href="#icon-print"></use>
                          </svg></span></a>
                    </div>
                    <div class="page-tools__right-item"><a class="button-icon" href="#"><span class="button-icon__icon">
                          <svg class="icon-icon-import">
                            <use xlink:href="#icon-import"></use>
                          </svg></span></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="toolbox">
            <div class="toolbox__row row gutter-bottom-xs">
                <div class="toolbox__left col-12 col-lg">
                    <div class="toolbox__left-row row row--xs gutter-bottom-xs">
                        <div class="form-group form-group--inline col-12 col-sm-auto">
                            <label class="form-label">Show</label>
                            <div class="input-group input-group--white input-group--append">
                                <input class="input input--select" type="text" value="10" size="1" data-toggle="dropdown" readonly><span class="input-group__arrow">
                            <svg class="icon-icon-keyboard-down">
                              <use xlink:href="#icon-keyboard-down"></use>
                            </svg></span>
                                <div class="dropdown-menu dropdown-menu--right dropdown-menu--fluid js-dropdown-select">
                                    <a class="dropdown-menu__item active show-item" href="#" tabindex="0" data-value="10">10</a>
                                    <a class="dropdown-menu__item show-item" href="#" tabindex="0" data-value="15">15</a>
                                    <a class="dropdown-menu__item show-item" href="#" tabindex="0" data-value="20">20</a>
                                    <a class="dropdown-menu__item show-item" href="#" tabindex="0" data-value="25">25</a>
                                    <a class="dropdown-menu__item show-item" href="#" tabindex="0" data-value="50">50</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-auto">
                    <button class="button-add button-add--blue" data-modal="#addcategory"><span class="button-add__icon">
                                    <svg class="icon-icon-plus">
                                    <use xlink:href="#icon-plus"></use>
                                    </svg></span><span class="button-add__text"></span>
                    </button>
                </div>
            </div>
        </div>
        <div style="display: flex; flex: 0; justify-content: space-between; ">
            <div class="table-wrapper" style="width:65%;">
                <div class="table-wrapper__content table-collapse scrollbar-thin scrollbar-visible" data-simplebar>
                    <table class="table table--spaces">
                        <colgroup>
                            <col width="90px">
                            <col >
                            <col >
                            <col >
                            <col width="100px">
                        </colgroup>
                        <thead class="table__header" style="background-color: white;">
                        <tr class="table__header-row">
                            <th class="table__th-sort"><span class="align-middle">ID</span>
                            </th>
                            <th class="table__th-sort"><span class="align-middle">Category Name</span>
                            </th>
                            <th class="table__th-sort" style="text-align: center;"><span class="align-middle" style="text-align: center;">Edit</span></th>
                        </tr>
                        </thead>
                        <tbody id="category-table">

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
            <div class="table-wrapper" style="width:30%;  background-color: white; padding: 2rem;">
                <form class="add-category__form" action="${pageContext.request.contextPath}/AdminCategoryServlet" method="post">
                    <input id="method" name="method" value="edit" hidden >
                    <div class="row row--md">
                        <div class="col-12 form-group form-group--lg">
                            <label class="form-label form-label--sm">category ID </label>
                            <div  class="input-group">
                                <input id="categoryId" name="categoryId"  class="input" type="number" placeholder="Id Category" required readonly>
                            </div>
                        </div>
                        <div class="col-12 form-group form-group--lg">
                            <label class="form-label form-label--sm">Category Name </label>
                            <div class="input-group">
                                <input id="categoryName" name="categoryName"class="input" type="text" placeholder="Name Category" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 form-group form-group--lg" style="display: flex; justify-content: center;">
                        <button class="button button--primary button--block" type="submit" ><span class="button__text">Edit</span>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>
</div>
<div class="modal modal--panel modal--right" id="addcategory">
    <div class="modal__overlay" data-dismiss="modal"></div>
    <div class="modal__wrap">
        <div class="modal__window scrollbar-thin" data-simplebar>
            <div class="modal__content">
                <div class="modal__header">
                    <div class="modal__container">
                        <h2 class="modal__title">Add Category</h2>
                    </div>
                </div>
                <div class="modal__body">
                    <div class="modal__container">
                        <form class="add-category__form" action="${pageContext.request.contextPath}/AdminCategoryServlet" method="post">
                            <input id="method2" name="method" value="create" hidden >
                            <div class="row row--md">
                                
                                <div class="col-12 form-group form-group--lg">
                                    <label class="form-label form-label--sm">category name</label>
                                    <div class="input-group">
                                        <input name="Name" class="input" type="text" placeholder="Category Name" required>
                                    </div>
                                </div>
                            </div>
                            <div class="add-category__submit" style="display: flex; justify-content: center;">
                                <div class="modal__footer-button" style="display: flex; justify-content: center;">
                                    <button class="button button--primary button--block" type="submit"><span class="button__text">Create</span>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal modal-compact modal-success scrollbar-thin" id="addcategorySuccess" data-simplebar>
    <div class="modal__overlay" data-dismiss="modal"></div>
    <div class="modal__wrap">
        <div class="modal__window">
            <div class="modal__content">
                <div class="modal__body">
                    <div class="modal__container">
                        <img class="modal-success__icon" src="Admin/assets/img/content/checked-success.svg" alt="#">
                        <h4 class="modal-success__title">category was added</h4>
                    </div>
                </div>
                <div class="modal-compact__buttons">
                    <div class="modal-compact__button-item">
                        <button class="modal-compact__button button" data-dismiss="modal" data-modal="#addcategory"><span class="button__text">Add new category</span>
                        </button>
                    </div>
                    <div class="modal-compact__button-item">
                        <button class="modal-compact__button button" data-dismiss="modal"><span class="button__text">Close</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    <c:if test="${requestScope.Message != null && requestScope.Message != '' }">
    alert("${requestScope.Message}");
    </c:if>
</script>
<script src="Admin/assets/js/custom/category.js"></script>
<jsp:include page="footerAdmin.jsp"/>