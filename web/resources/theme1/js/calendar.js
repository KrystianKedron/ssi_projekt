// kalendarz pochodzi z http://bootsnipp.com/snippets/j20Mj
$.getScript('http://arshaw.com/js/fullcalendar-1.6.4/fullcalendar/fullcalendar.min.js',function(){
  
  var date = new Date();
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();
  
  $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,agendaWeek,agendaDay'
    },
    editable: true,
    events: [
      {
        title: 'Wymiana klocków -R Kopp',
        start: new Date(y, 1, 1),
        allDay: false
      },
      {
        title: 'Wymiana sterów -A Gubała',
        start: new Date(y, 1, 23, 10, 30),
        // end: new Date(y, m, d+2)
        allDay: false
      },
      {
        id: 999,
        title: 'Zaplatanie przedniego koła -M Kumek',
        start: new Date(y, 0, 30, 16, 0),
        allDay: false
      },
      {
        id: 999,
        title: 'Pakiet pośredni -M Suseł',
        start: new Date(y, 1, 20, 16, 0),
        allDay: false
      },
      {
        title: 'Spotkanie z szefem',
        start: new Date(y, 1, 15, 12, 0),
        end: new Date(y, m, d, 14, 0),
        allDay: false
      },
      {
        title: 'Wymiana klocków -R Kopp',
        start: new Date(y, 2, 17, 12, 30),
        allDay: false
      },
      {
        title: 'Wymiana sterów -A Gubała',
        start: new Date(y, m, 23, 10, 30),
        // end: new Date(y, m, d+2)
        allDay: false
      },
      {
        id: 999,
        title: 'Zaplatanie przedniego koła -M Kumek',
        start: new Date(y, m-1, d+3, 16, 0),
        allDay: false
      },
      {
        id: 999,
        title: 'Pakiet pośredni -M Suseł',
        start: new Date(y, m-1, d+10, 16, 0),
        allDay: false
      },
      {
        title: 'Wyjazd służbowy',
        start: new Date(y, 0, 18, 12, 0),
        end: new Date(y, 0, 20, 14, 0),
        allDay: false
      },
      // {
      //   title: 'Lunch',
      //   start: new Date(y, m, d, 12, 0),
      //   end: new Date(y, m, d, 14, 0),
      //   allDay: false
      // },
      {
        title: 'Przyjęcie urodzinowe Michała',
        start: new Date(y, m, d+1, 19, 0),
        end: new Date(y, m, d+1, 22, 30),
        allDay: false
      },
      // {
      //   title: 'Click for Google',
      //   start: new Date(y, m, 28),
      //   end: new Date(y, m, 29),
      //   url: 'http://google.com/'
      // }
    ]
  });
})