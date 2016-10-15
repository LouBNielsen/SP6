$(document).ready(function(){
        
    $("#newQuote").click(function(){
        $("#divQuote").load("QuoteServlet"); 
    });
    
});