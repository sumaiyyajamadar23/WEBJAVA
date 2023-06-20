package dao;

import pojos.Player;

public interface PlayerDao 
{
String addPlayerToTeam(Player newplayer,Long teamid);
}
