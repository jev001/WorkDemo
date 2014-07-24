<!DOCTYPE html>
<html>
<head>
<--HEAD_LAYOUT-->
<link href="/css/lib.css" rel="stylesheet" type="text/css" />
<link href="/script/jquery.js" type="text/javascript" />
<script src="/scripts/swipe.js" type="text/javascript"></script>
<link href="/Templates/T59/T59.css" rel="stylesheet" type="text/css" />
<title>@Model.rModel.Title</title>
</head>
<body>
<style type="text/css">
    @Model.rModel.CssContent
    </style>

@using MobileShop
@{
    string phone = Model.rModel.TelPhone;
    List<ChannelItem> list = new List<ChannelItem>();
    foreach(ChannelItem item in Model.rModel.TModel.ChannelItems){
        if(item.ParentID == 0){
            list.Add(item);
        }
    }
}

<div class="wrapper">
    <div id='mySwipe' class='swipe'>
        <div class='swipe-wrap'>
            @foreach (var item in Model.rModel.TModel.BannerItems)
            { 
                <div class="img">
                    <a href="@item.JumpUrl">
                        <img src="@item.ImageUrl" width="100%"   class="tpbn" />
                        <b>&nbsp; </b></a>
                </div>
            }
        </div>
        <ul id="position">
            @foreach (var itemBanner in Model.rModel.TModel.BannerItems)
            { 
                <li></li>
            }
        </ul>
    </div>
    <script type="text/javascript">
        // pure JS
        var elem = document.getElementById('mySwipe');
        var bullets = document.getElementById('position').getElementsByTagName('li');
        window.mySwipe = Swipe(elem, {
            startSlide: 0,
            auto: 3000,
            continuous: true,
            // disableScroll: true,
            // stopPropagation: true,
            callback: function (pos) {
                var i = bullets.length;
                while (i--) {
                    bullets[i].className = ' ';
                }
                bullets[pos].className = 'on';
            }
            // transitionEnd: function(index, element) {}
        });

    </script>
    <a href="tel:@phone">
    <div class="phone clearfix">
        <img src="/Templates/T59/icon05.png" alt="" class="tpbn3" /><span>@phone</span>
    </div>
    </a>
    <ul class="fortyUl">
        @foreach (var item in list)
        {
            <li><a href="@item.JumpUrl">
                <img src="@item.PicUrl" class="tpbn2" />
                <h3 class="fortyH">@item.ChannelName</h3>
            </a></li>
        }
    </ul>
</div>


    <--FOOT_LAYOUT-->
</body>
</html>
