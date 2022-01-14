select c.name, 
b.serial_number as "body SN", 
e.serial_number as "engine SN", 
t.serial_number as "transmission SN"
from car as c 
left join body as b on c.body_id = b.id
left join engine as e on c.engine_id = e.id
left join transmission as t on c.transmission_id = t.id;






