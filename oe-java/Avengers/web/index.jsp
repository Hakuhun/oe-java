<%@page import="model.SuperTeam"%>
<%@page import="model.SuperHero"%>
<%@page import="service.TeamArranger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hőskezelő</title>
    </head>
    <body>
        <h1>Hős hozzáadása</h1>
        <form action="AddHeroServlet" method="GET">
            <label for="heroaddname">Hős neve: </label>
            <input id="heroaddname" type="text" name="name" placeholder="Hős neve">
            <label for="heroaddpower">A hős képességei: </label>
            <input id="heroaddpower" type="text" name="power" placeholder="Hős képességei">
            <br>
            <input type="submit" value="Hős hozzáadása">
        </form>
        
        <h1>Hősök listázása</h1>
        <%
            TeamArranger teamarranger = TeamArranger.getInstance();
            for (SuperHero hero : teamarranger.getHeroes()) {%>
                <%=hero.getName()%> : <%=hero.getHeroPower()%>
                <br>
                A hős csapatai: <%=teamarranger.getTeamsByHero(hero)%>
                <br>
                <!--<form action="AddMemberToTeamServlet?heroId=<%=hero.getId()%>" method="GET">-->
                <form action="AddMemberToTeamServlet" method="GET">
                    <select name="teamId">
                        <% for (SuperTeam team : teamarranger.getTeams()) {%>
                            <option value="<%=team.getId()%>">
                                <%=team.getName()%>
                            </option>
                        <%}%>
                    </select> 
                    <input type="hidden" name="heroId" value="<%=hero.getId()%>">
                    <input type="submit" value="Hozzáad">
                </form>

            <%}
        %>
        
        <h1>Csapat hozzáadása</h1>
        <form action="AddTeamServlet" method="GET">
            <label for="teamname">Csapat neve: </label>
            <input id="teamname" type="text" name="name" placeholder="Csapat neve">
            <br>
            <input type="submit" value="Csapat hozzáadása">
        </form>
    </body>
</html>
