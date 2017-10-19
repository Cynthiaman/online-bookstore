var shopproduct = shopsunindex = 1;
function userPayAllprice() {
    updateAllProdPrice()
}
function updateAllProdPrice() {
    var c = 0;
    var b = $("#Cart_List").find("li");
    if (b != null) {
        for (var a = 0; a < b.length; a++) {
            var d = $(b[a]).find("input[name='showFlag']").val();
            if (d == 0) {
                var f = $(b[a]).find(".price").text().match(/[0-9.\/]+/g);
                var e = $(b[a]).find(".price").parent().parent().find("input").val();
                c = parseFloat(c) + parseFloat(f) * parseFloat(e)
            }
        }
    }
    $("#userPayAllprice").text("￥" + c.toFixed(2));
    $("#userPayAllpriceList").text("￥" + c.toFixed(2))
}
function setCookie(h, g) {
    if (h.indexOf("quantity") >= 0 || h == "totalProdQty") {
        var e = window.location.href;
        e = e.substring(e.indexOf("//") + 2);
        e = e.substring(0, e.indexOf("/"));
        var b = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
        var a = e.match(b);
        if (a == null) {
            if (e.indexOf(".") > 0) {
                e = e.substring(e.indexOf("."))
            }
        }
        var c = e;
        var i = "/";
        var f = new Date();
        f.setHours(f.getHours() + 1);
        var d = h + "=" + escape(g) + ";domain=" + c + ";path=" + i + ";expires=" + f.toGMTString();
        document.cookie = d
    } else {
        document.cookie = h + "=" + escape(g)
    }
}
var addflag = false;
function addone(f, e) {
    var d = 1000;
    var c = parseFloat($("#userPayAllpriceList").text().match(/[0-9.\/]+/g));
    shopproduct = $(f).prev("input").val();
    shopproduct++;
    var a = true;
    if (shopproduct == 99) {}
    if (shopproduct > 99) {
        a = false;
        shopproduct = 99
    }
    setCookie("quantity_" + e, shopproduct);
    $(f).prev("input").val(shopproduct);
    var b = parseFloat($(f).parents("li").find(".price").text().match(/[0-9.\/]+/g));
    if (a) {
        c = c + b
    }
    $("#userPayAllpriceList").text("￥" + c.toFixed(2))
}
function lesone(e, d) {
    var c = 1000;
    var b = parseFloat($("#userPayAllpriceList").text().match(/[0-9.\/]+/g));
    shopproduct = $(e).next("input").val();
    shopproduct--;
    if (shopproduct < 1) {
        shopproduct = 1
    } else {
        $(e).next("input").val(shopproduct);
        var a = parseFloat($(e).parents("li").find(".price").text().match(/[0-9.\/]+/g));
        b -= a;
        $("#userPayAllpriceList").text("￥" + b.toFixed(2));
        setCookie("quantity_" + d, shopproduct)
    }
}
function getCookieValue() {
    var e = document.cookie.split("; ");
    for (var c = 0; c < e.length; c++) {
        var a = e[c].split("=");
        if (a[0].indexOf("quantity") >= 0) {
            var d = a[1];
            var b = document.getElementById(a[0]);
            if (b != null) {
                document.getElementById(a[0]).value = d
            } else {}
        }
    }
    updateAllProdPrice()
}
function updateTotalProdQty() {
    var c = 0;
    var a = $("input[name='quantity']");
    if (a != null) {
        for (var b = 0; b < a.length; b++) {
            var d = $(a[b]).attr("id").split("_");
            if (d.length < 3) {
                c++
            }
        }
    }
    setCookie("totalProdQty", c)
}
function refreshAllAmount() {
    updateAllProdPrice()
}
function refreshAllAmount(b) {
    var a = 0;
    a = $("#userPayAllpriceList").text();
    a = a.substring(a.indexOf("￥") + 1);
    a = parseFloat(a) - parseFloat(b);
    $("#userPayAllpriceList").text("￥" + a.toFixed(2))
}
function isDigit(b) {
    var a = /^([0-9]+)$/;
    if (a.test(b)) {
        return true
    } else {
        return false
    }
}
function validateProdQuantity(c, b, d) {
    var a = "";
    if (c.value == "" || "0" == c.value) {
        c.value = 1;
        refreshAllAmount();
        return false
    }
    if (!isDigit(c.value)) {
        c.value = 1;
        refreshAllAmount();
        return false
    }
    if (parseInt(c.value) > 99) {
        c.value = 99;
        a = "购买件数必须小于99！";
        document.getElementById(b).innerHTML = a;
        a = "";
        refreshAllAmount();
        return false
    }
    setCookie("quantity_" + d, c.value);
    document.getElementById(b).innerHTML = a;
    refreshAllAmount()
}
function showMessageInventoryAccesory(b, c) {
    var a;
    if (c == "OrderCheckOut") {
        a = "此商品库存不足"
    } else {
        a = "此商品库存不足,请重新添加"
    }
    document.getElementById(b).innerHTML = a
}
function showMessageVoucherAccesory(b) {
    var a = "优惠数量已用完";
    document.getElementById(b).innerHTML = a
}
function showMessagePriceAccesory(b) {
    var a = "该地点暂停销售";
    document.getElementById(b).innerHTML = a
}
function showMessageNoSalesAccesory(b) {
    var a = "商品暂不销售";
    document.getElementById(b).innerHTML = a
}
function showMessagePriceChgAccesory(b) {
    var a = "商品价格发生变化";
    document.getElementById(b).innerHTML = a
}
function showRushPurchTimeout(b) {
    var a = "您的抢购资格已过期";
    document.getElementById(b).innerHTML = a
}
function addHidEleToForm() {
    var f = document.getElementById("OrderCheckOut").innerHTML;
    var a = $("input[name='quantity']");
    var c = "";
    if (a != null) {
        for (var b = 0; b < a.length; b++) {
            var e = $(a[b]).parents("li").find("input[name='showFlag']").val();
            if (e == 0) {
                var d = $(a[b]).attr("id").split("_");
                if (d.length < 3) {
                    c = c + '<input type="hidden" name="' + $(a[b]).attr("id") + '" value="' + $(a[b]).val() + '"/>'
                }
                setCookie("quantity_" + $(a[b]).attr("id"), $(a[b]).val())
            }
        }
    }
    document.getElementById("OrderCheckOut").innerHTML = f + c
}
function showMessageNoInventory(a) {
    if (a != "") {
        $("#" + a).css("background", "#eee")
    }
}
function showMessageNoSalesAccesory(a) {
    if (a != "") {
        $("#" + a).attr("disabled", "disabled");
        $("#" + a).css("background", "#eee")
    }
}
function orderCheckOut() {
    var d;
    var b = $(".input-checkbox-a");
    var a = false;
    if (b != null) {
        for (var c = 0; c < b.length; c++) {
            if (b[c].checked == true) {
                a = true;
                break
            }
        }
    }
    if (!a) {
        d = "请至少选择一件商品！"
    } else {
        if ($("#inSameCity").val() == "false") {
            d = "购物车中的商品送达城市不一致，请返回商品详情页修改送货城市"
        }
    }
    if (d != "" && d != null) {
        alert(d)
    } else {
        addHidEleToForm();
        checkLogonStatus();
        if (isLogonStatus) {
            $("#URL").val("SNMWOrderCheckOut?URL=SNMWCart2ManageCmd");
            $("#OrderCheckOut").attr("action", "SNMWOrderCheckOut")
        } else {
            $("#URL").val("SNMWOrderItemDisplay");
            $("#OrderCheckOut").attr("action", "SNMWLogonView")
        }
        document.getElementById("OrderCheckOut").submit();
        return false
    }
    return false
}
function cardelclose(a) {
    $(a).remove()
}
function deletecart(b) {
    $(b).addClass("delete");
    if (confirm("确认删除吗？")) {
        $(b).parent().parents("li").find("input[name='showFlag']").val(1);
        $(b).parent().parents("li").slideUp("slow");
        var g = $(b).prev("input").val();
        setCookie("quantity_" + g, 0);
        var h = parseInt($("#allmounts").text().match(/[0-9.\/]+/g));
        if (h > 0) {
            h--
        }
        $("#allmounts").text(h);
        var c = $(b).parent().parent().find(".price").text().match(/[0-9.\/]+/g);
        var f = $(b).parent().parent().find(".price").parent().parent().find("input").val();
        var e = parseFloat(c) * parseFloat(f);
        refreshAllAmount(e);
        var i = $("#OrderCheckOut").find("input[name='storeId']").val();
        var d = $("#OrderCheckOut").find("input[name='catalogId']").val();
        var a = document.getElementById("deleteOrderIteam");
        a.elements.deleteSubmitFlag.value = 2;
        a.elements.orderItemId_1.value = $(b).prev("input").val();
        a.elements.deleteType.value = "N";
        a.elements.isKitWare_1.value = "0";
        $.ajax({
            type: "POST",
            url: "OrderItemAdd",
            data: $("#deleteOrderIteam").serialize(),
            cache: false,
            async: false,
            error: function(j, l, k) {},
            success: function(j) {
                window.location.href = "SNMWOrderItemDisplay?catalogId=" + d + "&storeId=" + i
            }
        })
    } else {
        $(b).removeClass("delete")
    }
}
function removeCart() {
    $("#Cart_List").find(".trash").bind("click",
    function() {
        $(this).addClass("delete");
        if (confirm("确认删除吗？")) {
            $(this).parents("li").find("input[name='showFlag']").val(1);
            $(this).parents("li").slideUp("slow");
            var g = $(this).prev("input").val();
            setCookie("quantity_" + g, 0);
            var b = parseInt($("#allmounts").text().match(/[0-9.\/]+/g));
            if (b > 0) {
                b--
            }
            $("#allmounts").text(b);
            var f = $(this).parent().find(".price").text().match(/[0-9.\/]+/g);
            var e = $(this).parent().find(".price").parent().parent().find("input").val();
            var d = parseFloat(f) * parseFloat(e);
            refreshAllAmount(d);
            var a = $("#OrderCheckOut").find("input[name='storeId']").val();
            var h = $("#OrderCheckOut").find("input[name='catalogId']").val();
            var c = document.getElementById("deleteOrderIteam");
            c.elements.deleteSubmitFlag.value = 2;
            c.elements.orderItemId_1.value = $(this).prev("input").val();
            c.elements.deleteType.value = "N";
            c.elements.isKitWare_1.value = "0";
            $.ajax({
                type: "POST",
                url: "OrderItemAdd",
                data: $("#deleteOrderIteam").serialize(),
                cache: false,
                async: false,
                error: function(i, k, j) {},
                success: function(i) {}
            })
        } else {
            $(this).removeClass("delete")
        }
    });
    $("#Cart_List").find("li").bind("swiperight",
    function() {
        $(this).find(".trash").addClass("delete");
        if (confirm("确认删除吗？")) {
            $(this).slideUp("slow");
            var e = $(this).prev("input").val();
            setCookie("quantity_" + e, 0);
            var a = parseInt($("#allmounts").text().match(/[0-9.\/]+/g));
            if (a > 0) {
                a--
            }
            $("#allmounts").text(a);
            var d = $(this).parent().find(".price").text().match(/[0-9.\/]+/g);
            var c = $(this).parent().find(".price").parent().parent().find("input").val();
            var b = parseFloat(d) * parseFloat(c);
            refreshAllAmount(b)
        } else {
            $(this).find(".trash").removeClass("delete")
        }
    })
}
function ProCounter() {
    $("#Cart_List").find(".countArea").each(function() {
        SNTouch.Widget.ProCounter({
            uid: $(this)
        })
    })
}
function select_choose() {
    $(".select-choose").each(function() {
        var a = $(this);
        $(this).change(function() {
            a.prev().html(a.find("option:selected").html())
        })
    })
}
$(function() {
    SNTouch.init();
    ProCounter();
    SNTouch.Widget.CityChoose();
    select_choose()
});