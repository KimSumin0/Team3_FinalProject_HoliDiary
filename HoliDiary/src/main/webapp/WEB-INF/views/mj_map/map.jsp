<html>
<head>
<title>Place Autocomplete and Directions</title>
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

<link rel="stylesheet" type="text/css" href="resources/css/mj_map.css" />
<script type="module" src="resources/js/mj_mapIndex.js"></script>
</head>
<body>

	<input id="pac-input" class="controls" type="text" placeholder="Search Box" />

	<div id="floating-panel">
		<input id="hide-markers" type="button" value="Hide Markers" /> 
		<input id="show-markers" type="button" value="Show Markers" /> 
		<input id="delete-markers" type="button" value="Delete Markers" />
	</div>

	<div id="map"></div>

	<!-- 
     The `defer` attribute causes the callback to execute after the full HTML
     document has been parsed. For non-blocking uses, avoiding race conditions,
     and consistent behavior across browsers, consider loading using Promises
     with https://www.npmjs.com/package/@googlemaps/js-api-loader.
    -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDb4vTBtJ5eI4DOAJXj4ov7YSdM066-PQ0&callback=initMap&v=weekly"
		defer></script>
</body>
</html>
