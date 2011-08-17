xquery version "1.0-ml";

for $i in xdmp:filesystem-directory('/')
return ( xdmp:set-response-content-type('application/xml; charset=utf-8'),  
"<tr><td><a href='shipmentrec.jsf?$filter=63333.00001'>63333.00001</a></td><td>08/11/2011 16:00</td><td>40</td><td></td><td>GOOD</td><td>NONE</td></tr>
<tr><td><a href='shipmentrec.jsf?$filter=63333.00002'>63333.00002</a></td><td>08/11/2011 16:00</td><td>40</td><td></td><td>GOOD</td><td>NONE</td></tr>
<tr><td><a href='shipmentrec.jsf?$filter=63333.00003'>63333.00003</a></td><td>08/11/2011 16:00</td><td>40</td><td></td><td>GOOD</td><td>NONE</td></tr>
<tr><td><a href='shipmentrec.jsf?$filter=63333.00004'>63333.00004</a></td><td>08/11/2011 16:00</td><td>40</td><td></td><td>GOOD</td><td>NONE</td></tr>
")
