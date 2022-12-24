require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: dateTime/dateTime.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Date
        q!: *(дат*)*
        script:
            $temp.date = currentDate();
        a: {{$temp.date.format("DD.MM.YYYY")}}

    state: Week Day
        q!: *(~день) * (недел*)*
        script: 
            $temp.date = currentDate();
        a: {{capitalize($temp.date.format("dddd"))}}

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}
