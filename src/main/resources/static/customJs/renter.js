$('.table #photoButton').on('click', function (event) {
    event.preventDefault();
    var href = $(this).attr('href');
    $('#photoModal #renterPhoto').attr('src', href);
    $('#photoModal').modal();
});