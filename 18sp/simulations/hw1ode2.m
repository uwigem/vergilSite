%this function accounts for behavior when a population goes extinct.
function odeout = ode(t,func,A,B,C,D)
%initialize an answer matrix. 
%The first row will have the result of x values, the second row will have the results of y values.
odeout = zeros(2,1); 

%set a condition where if the population of either the prey or predator
%falls below 0.01, it becomes "extinct".
if func(1)<0.01
    func(1)=0
else
    odeout(1) = A*func(1)-B*func(1)*func(2);
end
if func(2)<0.01
    func(2)=0
else 
    odeout(2) = -C*func(2)+D*func(1)*func(2);
end 