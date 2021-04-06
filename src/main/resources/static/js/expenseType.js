// delete button
$('.table #exampleModal').on('click',function(event){
    event.preventDefault();
    var href= $(this).attr('href');
    $('#exampleModal #delRef').attr('href', href);
    $('#exampleModal').modal();
});