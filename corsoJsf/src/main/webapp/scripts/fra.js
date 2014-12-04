

var FRA = function() {
};



FRA.onFebvButtonMouseOver = function(button) {
	var newImage = jQuery(button).attr("src").replace("e.gif", "m.gif");
	jQuery(button).attr("src", newImage);
};

FRA.onFebvButtonMouseOut = function(button) {
	var newImage = jQuery(button).attr("src").replace("m.gif", "e.gif");
	jQuery(button).attr("src", newImage);
};

