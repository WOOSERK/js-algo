const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	const stack = [];
	const strs = [];
	
	for await (const line of rl)
		strs.push(line);
	
	const [N, K] = strs[0].split(' ');
	
	for(let i=1; i<strs.length; i++)
	{
		const str = strs[i].split(' ');
		if(str[0] === 'push')
		{
			if(stack.length == K)
				console.log('Overflow');
			else
				stack.push(str[1]);
		}
		else
			console.log(stack.length === 0 ? 'Underflow' : stack.pop());
	}
	
	process.exit();
})();
