%this function accounts for behavior when a population goes extinct.
function odeout = ode(t,func,A,B,C,D)
%initialize an answer matrix. 
%The first row will have the result of x values, the second row will have the results of y values.
odeout = zeros(2,1); 

%func(1)=x
%func(2)=y
%this order corresponds with our initial vector (the init vector in the main script)
odeout(1) = A*func(1)-B*func(1)*func(2);
odeout(2) = -C*func(2)+D*func(1)*func(2);