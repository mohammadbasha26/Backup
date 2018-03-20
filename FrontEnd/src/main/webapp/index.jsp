 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
     
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
  <%@include file="header.jsp"%> 
<html>

<body>

	<h1 style="text-align: right" style="color:DodgerBlue"
		style="font-family:Goudy Stout;">
		<li class="active"><a href="home">TOY'S STORE!</a></li>
	</h1>
	</body>
	
	
	      
      <style>
body
{
    background-image: url("./resources/images/Donald_Duck_transparent.png");
    background-repeat: no-repeat;
	opacity:0.9;
    background-size: 60%; 
    padding-bottom: 75px;;
}</style>
	
<!--  <img src="./resources/images/Donald_Duck_transparent.png"alt=""style="width:200px;height:200px;" > -->
	<!-- <img src="./resources/images/3.gif" alt="HTML5 Icon" style="width:128px;height:128px;">  -->


</html>

 
 
 
 
<!--  
 
 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css">

            <script type="text/javascript" src="https://www.apptha.com/js/prototype/prototype.js"></script>
            <script type="text/javascript" src="https://www.apptha.com/js/scriptaculous/effects.js"></script>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
            <script>
                var nocon = jQuery.noConflict();
                var s = 1;
                nocon(document).ready(function() {
                    nocon("#show_header, #hide_header").click(function() {
                        if (s == 1) {
                            nocon("#show_header").show();
                            nocon("#hide_header").show();
//                            nocon("#toggle_btn").addClass('hide_header');
                            nocon("#iframe_container").addClass(' get_top');
//                            nocon("#toggle_btn").removeClass('show_header');
                            s = 0;
                        }
                        else {
                            nocon("#hide_header").hide();
                            nocon("#show_header").show();

//                            nocon("#toggle_btn").removeClass('hide_header');
                            nocon("#iframe_container").removeClass(' get_top');
//                            nocon("#toggle_btn").addClass('show_header');
                            s = 1;
                        }
                        nocon("#topheader").slideToggle();
                    });
                });
            </script>
    </head>
    <body>
        BEGIN GOOGLE ANALYTICS CODEs
        <script type="text/javascript">
            //<![CDATA[
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-3473681-77']);
            _gaq.push(['_trackPageview']);

            (function() {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();
            //]]>
        </script>
        END GOOGLE ANALYTICS CODE

                <div class="header_border">
            <div class="header-frame" id="topheader">
                <a href="https://www.apptha.com/"><img src="images/logo.png" alt="" title="" class="header_logo"/></a> 
                <div class="pdct_container">
                    <h1 class="pdct_name">Toys Store</h1>
                    </div>
                <a href="javascript:void(0);" class="show_header" id="show_header"></a>
                

                <div class="clear"></div>
            </div>
        </div>
        <a href="javascript:void(0);" class="hide_header" id="hide_header" style="display: none;"></a>


        Snap popup start
        <div id="apptha_SnapABug_WP">

            <div class="snap_bg-imgsrc"> 
                <a title="Close"id="snap_close" href="javascript:apptha_snapclose();"></a>
                
        </div>
        Snap popup ends


        <script type="text/javascript">
                   function apptha_snapopen()
                   {
                       $('apptha_SnapABug_WP').setStyle({
                           display: 'block'
                       });
                       $('apptha_SnapABug_WP').morph('width:350px;');
                   }

                   function apptha_snapclose()
                   {
                       $('apptha_SnapABug_WP').setStyle({
                           display: 'none'
                       });
                   }
                   
             
        </script>



        <div class="iframe_strip" id="iframe_container">
            <div class="bg_loader" id="bg_loader"> <div id="iframe_loading"><img src="images/loading.gif" alt="" title=""/></div>   </div>              
            <iframe id="iframe" src="http://www.apptha-demo.com/template/magento15/toysstore/index.php/" width="100%" height="100%" onload="loadhandler()"></iframe>
        </div>

        <script  type="text/javascript">
        (function() {
            var se = document.createElement('script'); se.type = 'text/javascript'; se.async = true;
            se.src = '//storage.googleapis.com/code.snapengage.com/js/634c5da5-4bdd-4608-b305-2150069fe0df.js';
            var done = false;
            se.onload = se.onreadystatechange = function() {
              if (!done&&(!this.readyState||this.readyState==='loaded'||this.readyState==='complete')) {
                done = true;
                /* Place your SnapEngage JS API code below */
                /* SnapEngage.allowChatSound(true); Example JS API: Enable sounds for Visitors. */

                var seAgent;
                SnapEngage.setCallback('OpenProactive', function(agent, msg) {
                   seAgent = agent;
                   _gaq.push(['_trackEvent', 'SnapEngage', 'proactivePrompt', agent]);
               });
                SnapEngage.setCallback('StartChat', function(email, msg, type) {
                   _gaq.push(['_trackEvent', 'SnapEngage', 'hasChatted', email]);
               });
                SnapEngage.setCallback('StartChat', function(email, msg, type) {
                   if (type == 'proactive') {
                       _gaq.push(['_trackEvent', 'SnapEngage', 'proactiveEngaged', seAgent]);
                   }
               });

               SnapEngage.getAgentStatusAsync(function(online) {   
                	   if(online == false) {
                	      window.setTimeout(apptha_snapopen, 20000);
                	   }
                	});  
                
              }
            };
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(se, s);
          })();

 
        </script>
        
        
        <script type="text/javascript">
            function loadhandler() {
            	nocon('#bg_loader').hide();
            	nocon('#iframe_loading').hide();
            }
        </script>


    </body>
</html> -->