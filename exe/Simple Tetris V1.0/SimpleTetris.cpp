#include <stdlib.h>
#include <windows.h>

int main(void)
{
	HWND hwnd=FindWindow("ConsoleWindowClass",NULL);
	if (hwnd)
	{
		ShowWindow(hwnd,SW_HIDE);
	}
	system("java -jar SimpleTetris.jar");
	return 0;
}
