%%% hw1ode2 refers to a different .m file that codes for a system of ODES %%%

%Quiver Plot (A plot of vectors for a function $u$ along values of (x,y). This is
%also called a phase plot)

figure(2)
%set up the meshgrid to plot on
x=linspace(0,20,50);
y=linspace(0,20,50);
[x,y]=meshgrid(x,y);
dudx = zeros(size(x));
dudy = zeros(size(x));

%iterate the ode for (x,y) grid and collect the derivatives.
f=@(t,func)(hw1ode2(t,func,A,B,C,D));
for i = 1:numel(x)
    Yprime = f(t,[x(i); y(i)]);
    dudx(i) = Yprime(1);
    dudy(i) = Yprime(2);
end

%some visual setup for the quiver plot
for i = 1:numel(x)
    Vmod = sqrt(dudx(i)^2 + dudy(i)^2);
    dudx(i) = dudx(i)/Vmod;
    dudy(i) = dudy(i)/Vmod;
end

%plot the quivers
quiver(x,y,dudx,dudy,'r'); figure(gcf)
xlabel('x')
ylabel('y')
axis tight equal;