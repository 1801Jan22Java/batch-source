count=0;
pokemonText = '{"pokemon":['+
	'{"name":"Pidgeot","IdNumber":18, "HP":83,"Attack":80,"Defence":75,"Special": 70,"Speed":91},'+
	'{"name":"Alakazam","IdNumber":65, "HP":55,"Attack":50,"Defence":45,"Special": 135,"Speed":120},'+
	'{"name":"Rhydon","IdNumber":112, "HP":105,"Attack":130,"Defence":120,"Special": 45,"Speed":40},'+
	'{"name":"Arcanine","IdNumber":59, "HP":90,"Attack":110,"Defence":80,"Special": 80,"Speed":95},'+
	'{"name":"Gyarados","IdNumber":130, "HP":95,"Attack":125,"Defence":79,"Special": 100,"Speed":81},'+
	'{"name":"Venusaur","IdNumber":3, "HP":80,"Attack":82,"Defence":83,"Special": 100,"Speed":80}]}';
pokemonObj = JSON.parse(pokemonText);
console.log(pokemonObj["pokemon"]);
window.onload = function()
{
	pokemon = document.getElementsByClassName("pokemon");
	console.log(pokemon);
	console.log(pokemonObj["pokemon"][0]);
	for(var i=0 ; i<pokemon.length; i++)
		{
		
//			console.log(pokemon[i].id);
			console.log((pokemonObj["pokemon"])[i]);
			var para = document.createElement("p");
			
			para.appendChild(document.createTextNode(pokemonObj["pokemon"][i]["name"]));
			para.appendChild(document.createTextNode('\t IdNumber: '));
			para.appendChild(document.createTextNode(pokemonObj["pokemon"][i]["IdNumber"]));
			para.appendChild(document.createTextNode("\t HP: "));
			para.appendChild(document.createTextNode(pokemonObj["pokemon"][i]["HP"]));
			para.appendChild(document.createTextNode("\t Attack: "));
			para.appendChild(document.createTextNode(pokemonObj["pokemon"][i]["Attack"]));
			para.appendChild(document.createTextNode("\t Defence: "));
			para.appendChild(document.createTextNode(pokemonObj["pokemon"][i]["Defence"]));
			para.appendChild(document.createTextNode("\t Special: "));
			para.appendChild(document.createTextNode(pokemonObj["pokemon"][i]["Special"]));
			para.appendChild(document.createTextNode("\t Speed: "));
			para.appendChild(document.createTextNode(pokemonObj["pokemon"][i]["Speed"]));
			para.setAttribute("style","font-size:20px");
			pokemon[i].parentElement.appendChild(para);	
		}
	//ChangeGaryGold();
	var Gary = document.getElementById("Gary");
	Gary.addEventListener("click", ChangeGary);
}
ChangeGary = function(){
	switch(count%5)
	{
	case 0:
		ChangeGaryGold();
		break;
	case 1:
		ChangeGaryFireRed();
		break;
	case 2:
		ChangeGarySunandMoon();
		break;
	case 3:
		ChangeGaryBlackandWhite();
		break;
	case 4:
		ChangeGaryRedandBlue();
		break;
	}
	count++;
};
ChangeGaryGold = function()
{
	//first find Gary
	var Gary = document.getElementById("Gary");
	var Pidgeot = document.getElementById("Pidgeot");
	var Alakazam = document.getElementById("Alakazam");
	var Rhydon = document.getElementById("Rhydon");
	var Gyarados = document.getElementById("Gyarados");
	var Arcanine = document.getElementById("Arcanine");
	var Venusaur = document.getElementById("Venusaur");

	Gary.setAttribute("src","https://cdn.bulbagarden.net/upload/thumb/6/6d/Yellow_Blue.png/100px-Yellow_Blue.png");
	Gary.setAttribute("style","hight:50");
	Gary.setAttribute("style","width:50");
	Pidgeot.setAttribute("src","https://www.serebii.net/pokearth/sprites/gold/018.png");
	Alakazam.setAttribute("src","https://www.serebii.net/pokearth/sprites/gold/065.png");
	Rhydon.setAttribute("src","https://www.serebii.net/pokearth/sprites/gold/112.png");
	Gyarados.setAttribute("src","https://www.serebii.net/pokearth/sprites/gold/130.png");
	Arcanine.setAttribute("src","https://www.serebii.net/pokearth/sprites/gold/059.png");
	Venusaur.setAttribute("src","https://www.serebii.net/pokearth/sprites/silver/003.png");
};
ChangeGaryFireRed = function()
{
	//first find Gary
	var Gary = document.getElementById("Gary");
	var Pidgeot = document.getElementById("Pidgeot");
	var Alakazam = document.getElementById("Alakazam");
	var Rhydon = document.getElementById("Rhydon");
	var Gyarados = document.getElementById("Gyarados");
	var Arcanine = document.getElementById("Arcanine");
	var Venusaur = document.getElementById("Venusaur");

	Gary.setAttribute("src","https://cdn.bulbagarden.net/upload/thumb/d/db/FireRed_LeafGreen_Blue.png/100px-FireRed_LeafGreen_Blue.png");
	Gary.setAttribute("style","hight:50");
	Gary.setAttribute("style","width:50");
	Pidgeot.setAttribute("src","https://www.serebii.net/pokearth/sprites/frlg/018.png");
	Alakazam.setAttribute("src","https://www.serebii.net/pokearth/sprites/frlg/065.png");
	Rhydon.setAttribute("src","https://www.serebii.net/pokearth/sprites/frlg/112.png");
	Gyarados.setAttribute("src","https://www.serebii.net/pokearth/sprites/frlg/130.png");
	Arcanine.setAttribute("src","https://www.serebii.net/pokearth/sprites/frlg/059.png");
	Venusaur.setAttribute("src","https://www.serebii.net/pokearth/sprites/frlg/003.png");
};
ChangeGaryRedandBlue = function()
{
	var Gary = document.getElementById("Gary");
	var Pidgeot = document.getElementById("Pidgeot");
	var Alakazam = document.getElementById("Alakazam");
	var Rhydon = document.getElementById("Rhydon");
	var Gyarados = document.getElementById("Gyarados");
	var Arcanine = document.getElementById("Arcanine");
	var Venusaur = document.getElementById("Venusaur");

	Gary.setAttribute("src","https://cdn.bulbagarden.net/upload/e/ee/Red_Blue_Blue.png");
	Gary.setAttribute("style","hight:50px");
	Gary.setAttribute("style","width:50px");
	Pidgeot.setAttribute("src","https://www.serebii.net/pokearth/sprites/rb/018.png");
	Alakazam.setAttribute("src","https://www.serebii.net/pokearth/sprites/rb/065.png");
	Rhydon.setAttribute("src","https://www.serebii.net/pokearth/sprites/rb/112.png");
	Gyarados.setAttribute("src","https://www.serebii.net/pokearth/sprites/rb/130.png");
	Arcanine.setAttribute("src","https://www.serebii.net/pokearth/sprites/rb/059.png");
	Venusaur.setAttribute("src","https://www.serebii.net/pokearth/sprites/rb/003.png");
}
ChangeGaryBlackandWhite = function()
{
	//first find Gary
	var Gary = document.getElementById("Gary");
	var Pidgeot = document.getElementById("Pidgeot");
	var Alakazam = document.getElementById("Alakazam");
	var Rhydon = document.getElementById("Rhydon");
	var Gyarados = document.getElementById("Gyarados");
	var Arcanine = document.getElementById("Arcanine");
	var Venusaur = document.getElementById("Venusaur");

	Gary.setAttribute("src","https://vignette.wikia.nocookie.net/nintendo/images/1/16/Blue.png/revision/latest?cb=20111016131709&path-prefix=en");
	Gary.setAttribute("style","hight:65px");
	Gary.setAttribute("style","width:65px");
	Pidgeot.setAttribute("src","https://www.serebii.net/blackwhite/pokemon/018.png");
	Alakazam.setAttribute("src","https://www.serebii.net/blackwhite/pokemon/065.png");
	Rhydon.setAttribute("src","https://www.serebii.net/blackwhite/pokemon/112.png");
	Gyarados.setAttribute("src","https://www.serebii.net/blackwhite/pokemon/130.png");
	Arcanine.setAttribute("src","https://www.serebii.net/blackwhite/pokemon/059.png");
	Venusaur.setAttribute("src","https://www.serebii.net/blackwhite/pokemon/003.png");
};
ChangeGarySunandMoon = function()
{
	console.log("wat");
	//first find Gary
	var Gary = document.getElementById("Gary");
	var Pidgeot = document.getElementById("Pidgeot");
	var Alakazam = document.getElementById("Alakazam");
	var Rhydon = document.getElementById("Rhydon");
	var Gyarados = document.getElementById("Gyarados");
	var Arcanine = document.getElementById("Arcanine");
	var Venusaur = document.getElementById("Venusaur");

	Gary.setAttribute("src","https://cdn.bulbagarden.net/upload/thumb/b/be/Sun_Moon_Blue.png/165px-Sun_Moon_Blue.png");
	Gary.setAttribute("style","hight:65px");
	Gary.setAttribute("style","width:65px");
	Pidgeot.setAttribute("src","https://www.serebii.net/sunmoon/pokemon/018.png");
	Alakazam.setAttribute("src","https://www.serebii.net/sunmoon/pokemon/065.png");
	Rhydon.setAttribute("src","https://www.serebii.net/sunmoon/pokemon/112.png");
	Gyarados.setAttribute("src","https://www.serebii.net/sunmoon/pokemon/130.png");
	Arcanine.setAttribute("src","https://www.serebii.net/sunmoon/pokemon/059.png");
	Venusaur.setAttribute("src","https://www.serebii.net/sunmoon/pokemon/003.png");
};