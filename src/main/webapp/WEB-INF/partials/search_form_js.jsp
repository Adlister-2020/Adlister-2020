<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/20/20
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>

<script>
    $(document).ready(function () {
        let categories = [
        <c:forEach items="${sessionScope.categoriesDao.all()}" var="category" varStatus="status">
            "${category.title}",
        </c:forEach>
        ""];

        let selectHTML = `<div id="searchSelect" class="container text-white d-flex flex-nowrap  mt-2">
                            `
        ;
        for(let i=0;i<categories.length;i++){
            selectHTML += '<div class="form-check form-check-inline">';
            selectHTML +=    '<input class="form-check-input" type="radio" name="category" id="radio' + i + '" value="'+ categories[i] +'">';
            selectHTML +=    '<label class="form-check-label" for="radio' + i + '">'+ categories[i] +'</label>';
            selectHTML += '</div>'
        }
        selectHTML += "</div>";
        selectHTML += "</form>";
        let searchForm = `
        <form action="/ads" method="get" id="searchForm" class="form-inline my-2 my-lg-0 mr-auto">
            <div class="container d-flex justify-content-center  ">
                <div class="input-group input-group-lg">
                    <div class="input-group-prepend">
                        <span id="searchBarPre" class="input-group-text shadow"></span>
                    </div>
                    <input type="text" class="form-control"  id="searchField" name="search" placeholder="Search" aria-label="Search">
                    <div class="input-group-append">
                        <button id="search" type="submit" class="input-group-text btn text-primary shadow">
                            <i class="fa fa-search p-0"></i>
                        </button>
                    </div>
                </div>
            </div>
        `;

        searchForm += selectHTML;
        function addForm(){
            if ($(window).width() <= 992){
                $('#mobile-search').html(searchForm);
                $('#mobile-search').css('display','block');
                $('#searchSelect').css('width','345px');
                $('#expanded-search').empty();
                $('#expanded-search').css('display','none');
            }else if($(window).width() > 992 && $(window).width()<1200){
                $('#mobile-search').empty();
                $('#mobile-search').css('display','none');
                $('#expanded-search').html(searchForm);
                $('#expanded-search').css('display','block');
                $('#searchSelect').css('width','600px');
            }
            else{
                $('#mobile-search').empty();
                $('#mobile-search').css('display','none');
                $('#expanded-search').html(searchForm);
                $('#expanded-search').css('display','block');
                $('#searchSelect').css('width','800px');
            }
        }

        addForm();
        $(window).resize(function () {
            addForm();
        });

    })
</script>