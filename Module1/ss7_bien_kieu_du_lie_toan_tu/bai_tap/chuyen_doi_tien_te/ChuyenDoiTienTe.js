function check() {
    var a,b,c, result;
    b = Number(document.getElementById("select").value);
    c = Number(document.getElementById("select2").value);
    a = Number(document.getElementById("a").value);
    if (b==c)
    {
        alert("you have enter two same Currency : please try again");
    }
    else{
        switch (b) {
            case 1 :
            {
                if (b==1 && c ==2)
                { result = 0.000044 * a;}
                else if (b==1 && c== 3)
                { result = 0.0050 * a;}
                else if (b==1 && c==4)
                {result = 0.00028 *a;}
                else if (b==1 && c==5)
                {result = 0.054  *a;}
                break;
            }
            case 2 :
            {
                if (b==2 && c==1)
                { result = 22850*a;}
                else if (b==2 && c==3)
                { result = 114.9*a;}
                else if (b==2 && c==4)
                {result = 6.32 *a;}
                else if (b==2 && c==5)
                {result = 1228.06*a;}
                break;
            }
            case 3:
            {
                if (b==3 && c==1)
                { result = 198.86*a;}
                else if (b==3 && c==2)
                { result = 0.0087*a;}
                else if (b==3 && c==4)
                {result = 0.055*a;}
                else if (b==3 && c==5)
                {result = 10.69 *a;}
                break;
            }
            case 4:
            {
                if (b==4 && c==1)
                { result =3613.91*a;}
                else if (b==4 && c==2)
                { result = 0.16*a;}
                else if (b==4 && c==3)
                {result = 18.17*a;}
                else if (b==4 && c==5)
                {result = 194.16*a;}
                break;
            }
            case 5:
            {
                if (b==5 && c==1)
                { result =18.62*a;}
                else if (b==5 && c==2)
                { result = 0.00081*a;}
                else if (b==5 && c==3)
                {result = 0.093*a;}
                else if (b==5 && c==4)
                {result = 0.0052*a;}
                break;
            }

        }
    }
    document.getElementById("answer").value=result;
}