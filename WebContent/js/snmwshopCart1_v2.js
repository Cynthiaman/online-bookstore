var quantityTimeId = null;
function addV2(obj, itemId) {
    var speed = 1000;
    var allprice = parseFloat($("#userPayAllpriceList").text().match(/[0-9.\/]+/g));
    var productNum = $(obj).prev("input").val();
    productNum++;
    var flag = true;
    if (productNum > 99) {
        flag = false;
        productNum = 99
    }
    $(obj).prev("input").val(productNum);
    if (quantityTimeId != null) {
        clearTimeout(quantityTimeId)
    }
    quantityTimeId = setTimeout(function() {
        var quantityList = $("input[name='quantity']");
        var quantityStr = "";
        if (quantityList != null) {
            for (var i = 0; i < quantityList.length; i++) {
                var strArr = $(quantityList[i]).attr("id").split("_");
                if (strArr.length < 3) {
                    if (i == 0) {
                        quantityStr = strArr[1] + "=" + $(quantityList[i]).val()
                    } else {
                        quantityStr = quantityStr + ";;" + strArr[1] + "=" + $(quantityList[i]).val()
                    }
                }
            }
        }
        var params = "method=updateQuantity&prodQuantity=" + quantityStr;
        $.ajax({
            url: "SNCartOperationCmd",
            data: params,
            cache: false,
            async: true,
            success: function(data) {
                var m = eval("(" + data + ")");
                if (m.result == "success") {
                    if (m.totalPrice == "") {
                        m.totalPrice = "0"
                    }
                    if (m.totalDiscount == "") {
                        m.totalDiscount = "0"
                    }
                    $("#userPayAllprice").text("￥" + parseFloat(m.totalPrice).toFixed(2));
                    $("#totalPromotionAmount").html("￥" + parseFloat(m.totalDiscount).toFixed(2));
                    var payAmount = parseFloat(m.totalPrice) - parseFloat(m.totalDiscount);
                    $("#userPayAllpriceList").html("￥" + payAmount.toFixed(2));
                    if (parseFloat(m.totalDiscount) > 0) {
                        $("#promotionAmountSpan").show()
                    } else {
                        $("#promotionAmountSpan").hide()
                    }
                }
            }
        })
    },
    speed)
}
function lesV2(obj, itemId) {
    var speed = 1000;
    var allprice = parseFloat($("#userPayAllpriceList").text().match(/[0-9.\/]+/g));
    var productNum = $(obj).next("input").val();
    productNum--;
    var flag = true;
    if (productNum < 1) {
        productNum = 1
    } else {
        $(obj).next("input").val(productNum);
        if (quantityTimeId != null) {
            clearTimeout(quantityTimeId)
        }
        quantityTimeId = setTimeout(function() {
            var quantityList = $("input[name='quantity']");
            var quantityStr = "";
            if (quantityList != null) {
                for (var i = 0; i < quantityList.length; i++) {
                    var strArr = $(quantityList[i]).attr("id").split("_");
                    if (strArr.length < 3) {
                        if (i == 0) {
                            quantityStr = strArr[1] + "=" + $(quantityList[i]).val()
                        } else {
                            quantityStr = quantityStr + ";;" + strArr[1] + "=" + $(quantityList[i]).val()
                        }
                    }
                }
            }
            var params = "method=updateQuantity&prodQuantity=" + quantityStr;
            $.ajax({
                url: "SNCartOperationCmd",
                data: params,
                cache: false,
                async: true,
                success: function(data) {
                    var m = eval("(" + data + ")");
                    if (m.result == "success") {
                        if (m.totalPrice == "") {
                            m.totalPrice = "0"
                        }
                        if (m.totalDiscount == "") {
                            m.totalDiscount = "0"
                        }
                        $("#userPayAllprice").text("￥" + parseFloat(m.totalPrice).toFixed(2));
                        $("#totalPromotionAmount").html("￥" + parseFloat(m.totalDiscount).toFixed(2));
                        var payAmount = parseFloat(m.totalPrice) - parseFloat(m.totalDiscount);
                        $("#userPayAllpriceList").html("￥" + payAmount.toFixed(2));
                        if (parseFloat(m.totalDiscount) > 0) {
                            $("#promotionAmountSpan").show()
                        } else {
                            $("#promotionAmountSpan").hide()
                        }
                    }
                }
            })
        },
        speed)
    }
}
/*function deleteCartItem(a) {
    $(a).addClass("delete");
    if (confirm("确认删除吗？")) {
        var b = $(a).prev("input").val();
        doDeleteCartItem(b)
    } else {
        $(a).removeClass("delete")
    }
}*/
function doDeleteCartItem(b, a) {
    $.ajax({
        type: "POST",
        url: "SNCartOperationCmd?method=deleteItem&itemId=" + b + "&ts=" + new Date().getTime(),
        cache: false,
        async: false,
        error: function(c, e, d) {},
        success: function(e) {
            var d = parseInt($("#allmounts").text().match(/[0-9.\/]+/g));
            if (d > 0) {
                d--
            }
            $("#allmounts").text(d);
            $(".delete").parent().parents("li").remove();
            inputQuantityV2();
            var c = $("#OrderCheckOut").find("input[name='storeId']").val();
            var f = $("#OrderCheckOut").find("input[name='catalogId']").val();
            window.location.href = "SNMWOrderItemDisplay?catalogId=" + f + "&storeId=" + c
        }
    })
}
function refreshCartContent() {
    var b = parseInt($("#allmounts").text().match(/[0-9.\/]+/g));
    if (b > 0) {
        b--
    }
    $("#allmounts").text(b);
    $(".delete").parent().parents("li").remove();
    inputQuantityV2();
    var a = $("#OrderCheckOut").find("input[name='storeId']").val();
    var c = $("#OrderCheckOut").find("input[name='catalogId']").val();
    window.location.href = "SNMWOrderItemDisplay?catalogId=" + c + "&storeId=" + a
}
function validateProdQuantityV2(c, b, d) {
    var a = "";
    if (c.value == "" || "0" == c.value) {
        c.value = 1;
        inputQuantityV2();
        return false
    }
    if (!isDigit(c.value)) {
        c.value = 1;
        inputQuantityV2();
        return false
    }
    if (parseInt(c.value) > 99) {
        c.value = 99;
        a = "购买件数必须小于99！";
        document.getElementById(b).innerHTML = a;
        a = "";
        inputQuantityV2();
        return false
    }
    document.getElementById(b).innerHTML = a
}
function inputQuantityV2() {
    var speed = 1000;
    if (quantityTimeId != null) {
        clearTimeout(quantityTimeId)
    }
    quantityTimeId = setTimeout(function() {
        var quantityList = $("input[name='quantity']");
        if (quantityList.length < 1) {
            $("#userPayAllprice").html("￥");
            $("#userPayAllpriceList").html("￥");
            return false
        }
        var quantityStr = "";
        if (quantityList != null) {
            for (var i = 0; i < quantityList.length; i++) {
                var strArr = $(quantityList[i]).attr("id").split("_");
                if (strArr.length < 3) {
                    if (i == 0) {
                        quantityStr = strArr[1] + "=" + $(quantityList[i]).val()
                    } else {
                        quantityStr = quantityStr + ";;" + strArr[1] + "=" + $(quantityList[i]).val()
                    }
                }
            }
        }
        var params = "method=updateQuantity&prodQuantity=" + quantityStr;
        $.ajax({
            url: "SNCartOperationCmd",
            data: params,
            cache: false,
            async: true,
            success: function(data) {
                var m = eval("(" + data + ")");
                if (m.result == "success") {
                    if (m.totalPrice == "") {
                        m.totalPrice = "0"
                    }
                    if (m.totalDiscount == "") {
                        m.totalDiscount = "0"
                    }
                    $("#userPayAllprice").text("￥" + parseFloat(m.totalPrice).toFixed(2));
                    $("#totalPromotionAmount").html("￥" + parseFloat(m.totalDiscount).toFixed(2));
                    var payAmount = parseFloat(m.totalPrice) - parseFloat(m.totalDiscount);
                    $("#userPayAllpriceList").html("￥" + payAmount.toFixed(2));
                    if (parseFloat(m.totalDiscount) > 0) {
                        $("#promotionAmountSpan").show()
                    } else {
                        $("#promotionAmountSpan").hide()
                    }
                }
            }
        })
    },
    speed)
}
var doForSelectTimer;
function doForSelectSNShop(itemId) {
    var allSNshopCheck = $("#Cart_List").find("input[type='checkbox']");
    if (doForSelectTimer != null) {
        clearTimeout(doForSelectTimer)
    }
    doForSelectTimer = setTimeout(function() {
        var itemids = "";
        var status = "";
        var all = true;
        $.each(allSNshopCheck,
        function(i, n) {
            itemids += $(n).attr("itemid") + ",";
            status += ($(n).attr("checked") ? "1": "0") + ","
        });
        $.get("SNCartOperationCmd?method=doSelectForItem&itemIds=" + itemids + "&itemStatus=" + status + "&ts=" + new Date().getTime(),
        function(data) {
            if ("" != data) {
                var m = eval("(" + data + ")");
                if (m.result == "success") {
                    if (m.totalPrice == "") {
                        m.totalPrice = "0"
                    }
                    if (m.totalDiscount == "") {
                        m.totalDiscount = "0"
                    }
                    $("#userPayAllprice").text("￥" + parseFloat(m.totalPrice).toFixed(2));
                    $("#totalPromotionAmount").html("￥" + parseFloat(m.totalDiscount).toFixed(2));
                    var payAmount = parseFloat(m.totalPrice) - parseFloat(m.totalDiscount);
                    $("#userPayAllpriceList").html("￥" + payAmount.toFixed(2));
                    if (parseFloat(m.totalDiscount) > 0) {
                        $("#promotionAmountSpan").show()
                    } else {
                        $("#promotionAmountSpan").hide()
                    }
                }
            }
        });
        if (doForSelectTimer != null) {
            clearTimeout(doForSelectTimer)
        }
    },
    500)
};