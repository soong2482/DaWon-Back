function CarlistJS(){
  var buttons = document.querySelectorAll('[id^="test_id"]');

  // Add click event listener to each button
  buttons.forEach(function(button) {
    button.addEventListener('click', function() {
  //     // Get id and field values
      var idValue = button.id;
      var fieldValue = button.getAttribute('field');

  //     // Log values to the console
      console.log('ID:', idValue, 'Field:', fieldValue);
    window.location.href="request?name="+idValue+"&sort="+fieldValue;
    });
  });
}
  
  export default CarlistJS;
  