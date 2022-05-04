var start = Math.floor(Math.random()*100);
var start1 = Math.floor(Math.random()*100);
var start2 = Math.floor(Math.random()*100);

function count(countTo, countContainer, parentContainer) {
    var i =0;
    var interval = setInterval(function() {
    if (i ===countTo) clearInterval(interval);
    $(countContainer).html(i++);
    $(countContainer).css("colo", "#ff5b" + i + "");
    $(parentContainer).css("border-color", "#ff5b" + i + "44");
    $(parentContainer).css("border-top-color", "transparent");
    $(".back").css("background", "#ff5b" + i +"5b");
    }, 50);
}
$(document).ready(function() {
    count(start, ".def-cnt", ".defence");
    count(start1, ".atc-cnt", ".attack");
    count(start2, ".dis-cnt", ".distance");

    $(".addMember").click(function(){
    $("#newMember").css("left", "0%");
    });
    $(".close").click(function(){
    $("#newMember").css("left", "100%");
    });
});